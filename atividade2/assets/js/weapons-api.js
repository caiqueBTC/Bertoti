const WeaponsApi = {}

const baseURL = `http://localhost:8080/weapons`

WeaponsApi.GetWeapons = () => {
    const url = baseURL
    return fetch(url)
        .then((response) => response.json())
        .catch((error) => console.error(error))
}

WeaponsApi.InsertWeapon = (newWeapon) => {
    return fetch(baseURL, {
        method: 'POST',
        headers: {
            'Content-Type' : 'application/json'
        },
        body: JSON.stringify(newWeapon)
    })
    .then(res => res.json())
    .catch((error) => console.error(error))
}

WeaponsApi.DeleteWeapon = (idToDelete) => {
    return fetch(baseURL + `/${idToDelete}`, {
        method: 'DELETE',
      })
      .then(res => console.log(res))
      .catch((error) => console.error(error))
}