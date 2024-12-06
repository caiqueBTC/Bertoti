function convertWeaponToHtml(weapon) {
    return `
    <li class="weapon">
       <span class="name"> ${weapon.name} </span>
            <div class="pagination">
                <button id="${weapon.id}" onClick="delete_click()" type="button">
                    Deletar
                </button>
            </div>
    </li>`
}

function loadWeaponList() {
    WeaponsApi.GetWeapons()
        .then((weaponList = []) => {
            console.log(weaponList)
            weaponHtmlList = document.getElementById('WeaponList')
            weaponHtmlList.innerHTML += weaponList.map(convertWeaponToHtml).join('')
        })
        .catch((error) => console.log(error))
}

loadWeaponList()

adicionarButton.addEventListener('click', () => {

    let newName = document.getElementById('wname').value

    if (newName) {
        newWeapon = new Weapon()
        newWeapon.name = newName
        WeaponsApi.InsertWeapon(newWeapon)
            .then(data => console.log(data))
            .catch((error) => console.error(error))

        location.reload()
    }
    else {
        console.log('Input Inválido')
    }


})

function delete_click() {
    idToDelete = event.srcElement.id

    WeaponsApi.DeleteWeapon(idToDelete)

    location.reload()
}