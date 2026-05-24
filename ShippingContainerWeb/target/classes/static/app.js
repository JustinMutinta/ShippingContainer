'use strict';

// ── State ─────────────────────────────────────────────────────
let availableItems    = [];
let containerMap      = {};   // name → ContainerInfo
let selectedAvailId   = null;
let selectedContId    = null;
let currentContainer  = 'Container 1';

// ── DOM refs ──────────────────────────────────────────────────
const containerSelect = document.getElementById('container-select');
const addBtn          = document.getElementById('add-btn');
const removeBtn       = document.getElementById('remove-btn');
const statusBar       = document.getElementById('status-bar');

// ── Boot ──────────────────────────────────────────────────────
async function init() {
    containerSelect.addEventListener('change', () => {
        currentContainer = containerSelect.value;
        selectedContId   = null;
        renderContainerPanel();
        renderDetailsTable();
    });
    addBtn.addEventListener('click',    addItem);
    removeBtn.addEventListener('click', removeItem);

    await refreshAll();
}

// ── Data refresh ──────────────────────────────────────────────
async function refreshAll() {
    const [itemsRes, containersRes] = await Promise.all([
        fetch('/api/items/available'),
        fetch('/api/containers')
    ]);
    availableItems = await itemsRes.json();
    const list     = await containersRes.json();

    containerMap = {};
    list.forEach(c => containerMap[c.name] = c);

    selectedAvailId = null;
    selectedContId  = null;

    renderAvailablePanel();
    renderContainerPanel();
    renderDetailsTable();
}

// ── Render: available items ───────────────────────────────────
function renderAvailablePanel() {
    const ul    = document.getElementById('available-list');
    const badge = document.getElementById('available-count');
    badge.textContent = availableItems.length;

    if (availableItems.length === 0) {
        ul.innerHTML = '<li class="placeholder">No items available</li>';
        return;
    }

    ul.innerHTML = availableItems
        .map(item => `<li data-id="${item.id}"
                class="${item.id === selectedAvailId ? 'selected' : ''}">
                ${item.description}
             </li>`)
        .join('');

    ul.querySelectorAll('li').forEach(li =>
        li.addEventListener('click', () => {
            selectedAvailId = parseInt(li.dataset.id);
            selectedContId  = null;
            renderAvailablePanel();
            renderContainerPanel();
        })
    );
}

// ── Render: container panel ───────────────────────────────────
function renderContainerPanel() {
    const info   = containerMap[currentContainer] || { items: [], capacity: 0, used: 0 };
    const ul     = document.getElementById('container-list');
    const title  = document.getElementById('container-title');
    const badge  = document.getElementById('container-count');
    const bar    = document.getElementById('cap-bar');
    const capTxt = document.getElementById('cap-text');

    title.textContent = currentContainer;
    badge.textContent = info.used;
    capTxt.textContent = `${info.used} / ${info.capacity} slots used`;

    const pct = info.capacity > 0 ? (info.used / info.capacity) * 100 : 0;
    bar.style.width = pct + '%';
    bar.className = 'cap-bar' + (pct === 100 ? ' full' : pct >= 60 ? ' high' : '');

    if (info.items.length === 0) {
        ul.innerHTML = '<li class="placeholder">Empty</li>';
        return;
    }

    ul.innerHTML = info.items
        .map(item => `<li data-id="${item.id}"
                class="${item.id === selectedContId ? 'selected' : ''}">
                ${item.description}
             </li>`)
        .join('');

    ul.querySelectorAll('li').forEach(li =>
        li.addEventListener('click', () => {
            selectedContId  = parseInt(li.dataset.id);
            selectedAvailId = null;
            renderAvailablePanel();
            renderContainerPanel();
        })
    );
}

// ── Render: details table ─────────────────────────────────────
function renderDetailsTable() {
    const tbody = document.getElementById('details-body');
    const info  = containerMap[currentContainer];

    if (!info || info.items.length === 0) {
        tbody.innerHTML =
            '<tr><td colspan="6" class="placeholder">This container is empty.</td></tr>';
        return;
    }

    tbody.innerHTML = info.items
        .map(item => `
            <tr>
                <td>${item.description}</td>
                <td>${item.serialNumber}</td>
                <td>${item.height}</td>
                <td>${item.width}</td>
                <td>${item.length}</td>
                <td>${item.weight}</td>
            </tr>`)
        .join('');
}

// ── Add item ──────────────────────────────────────────────────
async function addItem() {
    if (!selectedAvailId) {
        setStatus('Select an item from the left list first.', 'error');
        return;
    }
    const name = encodeURIComponent(currentContainer);
    const res  = await fetch(`/api/containers/${name}/items/${selectedAvailId}`, {
        method: 'POST'
    });
    const data = await res.json();
    setStatus(data.message, data.success ? 'success' : 'error');
    if (data.success) await refreshAll();
}

// ── Remove item ───────────────────────────────────────────────
async function removeItem() {
    if (!selectedContId) {
        setStatus('Select an item from the right list first.', 'error');
        return;
    }
    const res  = await fetch(`/api/items/${selectedContId}/placement`, {
        method: 'DELETE'
    });
    const data = await res.json();
    setStatus(data.message, data.success ? 'success' : 'error');
    if (data.success) await refreshAll();
}

// ── Status bar ────────────────────────────────────────────────
function setStatus(message, type = '') {
    statusBar.textContent = message;
    statusBar.className   = 'status-bar ' + type;
}

init();
