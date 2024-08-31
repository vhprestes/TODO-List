window.onload = function() {
    console.log('Hello World');
}

const button = document.getElementById('submitButton');
const tableBody = document.getElementById('tbody');
let originalRows = [];
const resetButton = document.getElementById('resetFilters');
const filter = document.getElementById('filter');

button.addEventListener('click', function() {
    console.log('Button clicked, onclick function called!');
    createNewRow();
    fieldCleaner();
    originalRows = Array.from(document.querySelectorAll('#tbody tr')).map(row => row.cloneNode(true));
    console.log(originalRows);
});

filter.addEventListener('change', function() {
    filterByStatus(filter.value);
});

resetButton.addEventListener('click', function() {
    resetFilters();
});

const createNewRow = () => {
    const title = document.getElementById('task-name').value;
    const description = document.getElementById('task-description').value;
    const date = document.getElementById('task-date').value;
    const priority = document.getElementById('task-priority').value;
    const status = document.getElementById('task-status').value;
    const category = document.getElementById('category-id').value;

    const tr = document.createElement('tr');
    const tdTitle = document.createElement('td');
    const tdDescription = document.createElement('td');
    const tdDate = document.createElement('td');
    const tdPriority = document.createElement('td');
    const tdCategory = document.createElement('td');
    const tdStatus = document.createElement('td');

    tdTitle.innerText = title;
    tdDescription.innerText = description;
    tdDate.innerText = date;
    tdPriority.innerText = priority;
    tdCategory.innerText = category;
    tdStatus.innerText = status;

    const buttonDelete = document.createElement('button');
    buttonDelete.innerText = "X";
    buttonDelete.type = "button";
    buttonDelete.className = "deleteBtn";

    buttonDelete.addEventListener('click', function() {
        tr.remove();
    });

    const buttonEdit = document.createElement('button');
    buttonEdit.innerText = "Edit";
    buttonEdit.type = "button";
    buttonEdit.className = "editBtn";

    buttonEdit.addEventListener('click', function() {
        editRow(tr, buttonEdit);
    });

    tr.appendChild(tdTitle);
    tr.appendChild(tdDescription);
    tr.appendChild(tdDate);
    tr.appendChild(tdPriority);
    tr.appendChild(tdCategory);
    tr.appendChild(tdStatus);
    tr.appendChild(buttonEdit);
    tr.appendChild(buttonDelete);
    tableBody.appendChild(tr);
}

const editRow = (tr, buttonEdit) => {
    const tds = tr.querySelectorAll('td');
    tds.forEach((td, index) => {
        let input;
        if (index === 2) { // Data
            input = document.createElement('input');
            input.type = 'date';
            input.value = td.innerText;
        } else if (index === 3) { // Prioridade
            input = document.createElement('input');
            input.type = 'number';
            input.min = 1;
            input.max = 5;
            input.value = td.innerText;
        } else if (index === 4) { // Categoria
            input = document.createElement('select');
            ['Casa', 'Estudos', 'Trabalho', 'Lazer'].forEach(optionText => {
                const option = document.createElement('option');
                option.value = optionText;
                option.innerText = optionText;
                if (td.innerText === optionText) {
                    option.selected = true;
                }
                input.appendChild(option);
            });
        } else if (index === 5) { // Status
            input = document.createElement('select');
            ['to do', 'in progress', 'done'].forEach(optionText => {
                const option = document.createElement('option');
                option.value = optionText;
                option.innerText = optionText;
                if (td.innerText.toLowerCase() === optionText.replace(' ', '-')) {
                    option.selected = true;
                }
                input.appendChild(option);
            });
        } else { // Outros campos
            input = document.createElement('input');
            input.type = 'text';
            input.value = td.innerText;
        }
        td.innerText = '';
        td.appendChild(input);
    });

    const buttonSave = document.createElement("button");
    buttonSave.innerText = "Save";
    buttonSave.type = "button";
    buttonSave.className = "saveBtn";

    buttonSave.addEventListener('click', function() {
        saveRow(tr, buttonSave);
    });

    tr.appendChild(buttonSave);
    buttonEdit.style.display = 'none';
}

const saveRow = (tr, buttonSave) => {
    const tds = tr.querySelectorAll('td');
    tds.forEach(td => {
        const input = td.querySelector('input');
        const select = td.querySelector('select');

        if (input) {
            td.innerText = input.value;
        } else if (select) {
            td.innerText = select.value;
        }
    });

    const buttonEdit = tr.querySelector('.editBtn');
    buttonEdit.style.display = 'inline';
    buttonSave.remove();
}

const fieldCleaner = () => {
    document.getElementById('task-name').value = "";
    document.getElementById('task-description').value = "";
    document.getElementById('task-date').value = "";
    document.getElementById('task-priority').value = "1";
    document.getElementById('task-status').value = "todo";
    document.getElementById('category-id').value = "Casa";
}

const filterByStatus = (status) => {
    if (originalRows.length === 0) {
        originalRows = Array.from(document.querySelectorAll('#tbody tr')).map(row => row.cloneNode(true));
    }

    const rows = document.querySelectorAll('#tbody tr');
    rows.forEach(row => {
        const statusCell = row.children[5]; // status == 6th col
        if (statusCell.innerText.toLowerCase() === status.toLowerCase().replace(' ', '-')) {
            row.style.display = '';
        } else {
            row.style.display = 'none';
        }
    });
}

const resetFilters = () => {
    const tbody = document.getElementById('tbody');
    tbody.innerHTML = '';
    originalRows.forEach(row => {
        tbody.appendChild(row.cloneNode(true));
    });
    console.log('Filters reset');
}