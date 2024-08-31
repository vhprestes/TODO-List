window.onload = function() {
    console.log('Hello World');

}

const button = document.getElementById('submitButton')
const tableBody = document.getElementById('tbody')
const lines = document.getElementsByTagName('tr')
// console.log(lines)
let index = 0




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
    tdStatus.innerText = status

    const buttonDelete = document.createElement("button")
    buttonDelete.id = "deleteBtn"
    buttonDelete.innerText = "X"
    buttonDelete.type = "button"
    buttonDelete.className = String(index)
    index++


    buttonDelete.addEventListener('click', function() {
    tr.remove();
    })

    tr.appendChild(tdTitle);
    tr.appendChild(tdDescription);
    tr.appendChild(tdDate);
    tr.appendChild(tdPriority);
    tr.appendChild(tdCategory);
    tr.appendChild(tdStatus);
    tr.appendChild(buttonDelete)
    tableBody.appendChild(tr);
    }



const fieldCleaner = () => {
    document.getElementById('task-name').value = ""
    document.getElementById('task-description').value = ""
    document.getElementById('task-date').value = ""
    document.getElementById('task-priority').value = ""
    document.getElementById('task-status').value = ""
    document.getElementById('category-id').value = ""
}
