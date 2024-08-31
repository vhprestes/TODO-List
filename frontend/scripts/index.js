window.onload = function() {
    console.log('Hello World');
}

const button = document.getElementById('submitButton');
const tableBody = document.getElementById('tbody');


button.addEventListener('click', function() {
    console.log('Button clicked, onclick function called!');
    createNewRow();
    fieldCleaner();
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
    tds.forEach(td => {
        const input = document.createElement('input');
        input.type = 'text';
        input.value = td.innerText;
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
        if (input) {
            td.innerText = input.value;
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
    document.getElementById('task-priority').value = "";
    document.getElementById('task-status').value = "";
    document.getElementById('category-id').value = "";
}