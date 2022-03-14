
const getList =document.querySelector('#getList')

getList.addEventListener('click',()=>{
    fetch('http://localhost:8080/contacts', {method: 'GET'})
        .then(response => response.json())
        .then(data =>{
            console.log(data[0].name)
            const contacts = document.querySelector('#contacts-container');
            let html = '';
            data.forEach(contact =>{
                html += `<div>${contact.id}${'. '}${contact.name}</div>`
            });
            contacts.innerHTML = html;
        })

})


