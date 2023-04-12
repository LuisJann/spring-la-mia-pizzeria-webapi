/*Variabili globali */
const apiURL = "http://localhost:8080/api/v1/pizzas";
const contentElement = document.getElementById('content');
const form = document.querySelector('form');
const searchInput = form.querySelector('#search-input');
const toggleForm = document.getElementById('toggle-form');


/*API*/
const getPizzaList = async () => {
    const response = await fetch(apiURL);
    return response;
};

const postPizza = async (jsonData) => {
    const fetchOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: jsonData,
    };
    const response = await fetch(apiURL, fetchOptions);
    return response;
};

const deleteBookById = async (pizzaId) => {
    const response = await fetch(apiURL + '/' + pizzaId, { method: 'DELETE' });
    return response;
};

const filterPizza = (event) => {
    event.preventDefault();

    const searchValue = searchInput.value.toLowerCase();

    fetch(apiURL)
        .then(response => response.json())
        .then(items => {
            const filteredItems = items.filter((item) => {
                const itemName = item.name.toLowerCase();
                return itemName.includes(searchValue);
            });

            console.log(filteredItems);
            contentElement.innerHTML = createPizzaList(filteredItems);


        })
        .catch(error => {
            console.error(error);
        });
}
form.addEventListener('submit', filterPizza);

const createPizzaItem = (item) => {
    console.log(item);
    return `<li class="list-group-item"> <h4> ${item.name} </h4> <span> ${item.description} </span> <br> <span class="text-danger"> ${item.price} €</span> </li>`
};


const createPizzaList = (data) => {
    console.log(data);
    let list = `<ul class="list-group mt-5">`;
    data.forEach(element => {
        list += createPizzaItem(element)
    });
    list += `</ul>`;
    console.log(data);

    return list;
};

const laodData = async () => {
    const response = await getPizzaList();
    console.log(response);
    if (response.ok) {
        const data = await response.json();
        console.log(data);
        contentElement.innerHTML = createPizzaList(data);

    } else {
        console.log("ERROE");
    }
}


const createDeleteBtn = (pizza) => {
    let btn = '';
    btn = `<button data-id="${pizza.id}" class="btn btn-danger">
              Delete
          </button>`;
    return btn;
};

// DOM
toggleForm.addEventListener("click", (event) => {
    document.getElementById('form').classList.toggle('d-none');
})







/*CODE*/
laodData();