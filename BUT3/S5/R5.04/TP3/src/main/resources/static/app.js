const API_BASE_URL = 'http://localhost:8080/api';

function showMessage(elementId, message, type) {
    const messageDiv = document.getElementById(elementId);
    messageDiv.textContent = message;
    messageDiv.className = `message ${type}`;
    messageDiv.style.display = 'block';
    
    setTimeout(() => {
        messageDiv.style.display = 'none';
    }, 3000);
}

function createDepartement() {
    const nom = document.getElementById('dept-nom').value;
    const localisation = document.getElementById('dept-localisation').value;
    
    if (!nom) {
        showMessage('dept-message', 'Le nom du département est requis', 'error');
        return;
    }
    
    const departement = {
        nom: nom,
        localisation: localisation
    };
    
    fetch(`${API_BASE_URL}/departements/create`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(departement)
    })
    .then(response => response.json())
    .then(data => {
        showMessage('dept-message', 'Département créé avec succès!', 'success');
        document.getElementById('dept-nom').value = '';
        document.getElementById('dept-localisation').value = '';
        loadDepartements();
        loadDepartementOptions();
    })
    .catch(error => {
        showMessage('dept-message', 'Erreur lors de la création: ' + error, 'error');
    });
}

function loadDepartements() {
    fetch(`${API_BASE_URL}/departements`)
    .then(response => response.json())
    .then(data => {
        displayDepartements(data);
    })
    .catch(error => {
        showMessage('dept-message', 'Erreur lors du chargement: ' + error, 'error');
    });
}

function displayDepartements(departements) {
    const listDiv = document.getElementById('dept-list');
    
    if (departements.length === 0) {
        listDiv.innerHTML = '<p>Aucun département trouvé.</p>';
        return;
    }
    
    let html = '<table><thead><tr><th>ID</th><th>Nom</th><th>Localisation</th><th>Actions</th></tr></thead><tbody>';
    
    departements.forEach(dept => {
        html += `
            <tr>
                <td>${dept.id}</td>
                <td>${dept.nom}</td>
                <td>${dept.localisation || '-'}</td>
                <td>
                    <button class="delete" onclick="deleteDepartement(${dept.id})">Supprimer</button>
                </td>
            </tr>
        `;
    });
    
    html += '</tbody></table>';
    listDiv.innerHTML = html;
}

function deleteDepartement(id) {
    if (!confirm('Êtes-vous sûr de vouloir supprimer ce département?')) {
        return;
    }
    
    fetch(`${API_BASE_URL}/departements/${id}`, {
        method: 'DELETE'
    })
    .then(() => {
        showMessage('dept-message', 'Département supprimé avec succès!', 'success');
        loadDepartements();
        loadDepartementOptions();
    })
    .catch(error => {
        showMessage('dept-message', 'Erreur lors de la suppression: ' + error, 'error');
    });
}

function loadDepartementOptions() {
    fetch(`${API_BASE_URL}/departements`)
    .then(response => response.json())
    .then(data => {
        const select = document.getElementById('collab-dept');
        select.innerHTML = '<option value="">Sélectionner un département</option>';
        
        data.forEach(dept => {
            const option = document.createElement('option');
            option.value = dept.id;
            option.textContent = dept.nom;
            select.appendChild(option);
        });
    })
    .catch(error => {
        console.error('Erreur lors du chargement des départements:', error);
    });
}

function createCollaborateur() {
    const matricule = document.getElementById('collab-matricule').value;
    const nom = document.getElementById('collab-nom').value;
    const prenom = document.getElementById('collab-prenom').value;
    const email = document.getElementById('collab-email').value;
    const telephone = document.getElementById('collab-telephone').value;
    const deptId = document.getElementById('collab-dept').value;
    
    if (!matricule || !nom || !prenom) {
        showMessage('collab-message', 'Le matricule, nom et prénom sont requis', 'error');
        return;
    }
    
    const collaborateur = {
        matricule: matricule,
        nom: nom,
        prenom: prenom,
        email: email,
        telephone: telephone,
        departement: deptId ? { id: deptId } : null
    };
    
    fetch(`${API_BASE_URL}/collaborateurs/create`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(collaborateur)
    })
    .then(response => response.json())
    .then(data => {
        showMessage('collab-message', 'Collaborateur créé avec succès!', 'success');
        document.getElementById('collab-matricule').value = '';
        document.getElementById('collab-nom').value = '';
        document.getElementById('collab-prenom').value = '';
        document.getElementById('collab-email').value = '';
        document.getElementById('collab-telephone').value = '';
        document.getElementById('collab-dept').value = '';
        loadCollaborateurs();
    })
    .catch(error => {
        showMessage('collab-message', 'Erreur lors de la création: ' + error, 'error');
    });
}

function loadCollaborateurs() {
    fetch(`${API_BASE_URL}/collaborateurs`)
    .then(response => response.json())
    .then(data => {
        displayCollaborateurs(data);
    })
    .catch(error => {
        showMessage('collab-message', 'Erreur lors du chargement: ' + error, 'error');
    });
}

function displayCollaborateurs(collaborateurs) {
    const listDiv = document.getElementById('collab-list');
    
    if (collaborateurs.length === 0) {
        listDiv.innerHTML = '<p>Aucun collaborateur trouvé.</p>';
        return;
    }
    
    let html = '<table><thead><tr><th>Matricule</th><th>Nom</th><th>Prénom</th><th>Email</th><th>Téléphone</th><th>Département</th><th>Actions</th></tr></thead><tbody>';
    
    collaborateurs.forEach(collab => {
        html += `
            <tr>
                <td>${collab.matricule}</td>
                <td>${collab.nom}</td>
                <td>${collab.prenom}</td>
                <td>${collab.email || '-'}</td>
                <td>${collab.telephone || '-'}</td>
                <td>${collab.departement ? collab.departement.nom : '-'}</td>
                <td>
                    <button class="delete" onclick="deleteCollaborateur('${collab.matricule}')">Supprimer</button>
                </td>
            </tr>
        `;
    });
    
    html += '</tbody></table>';
    listDiv.innerHTML = html;
}

function deleteCollaborateur(matricule) {
    if (!confirm('Êtes-vous sûr de vouloir supprimer ce collaborateur?')) {
        return;
    }
    
    fetch(`${API_BASE_URL}/collaborateurs/delete/${matricule}`, {
        method: 'DELETE'
    })
    .then(() => {
        showMessage('collab-message', 'Collaborateur supprimé avec succès!', 'success');
        loadCollaborateurs();
    })
    .catch(error => {
        showMessage('collab-message', 'Erreur lors de la suppression: ' + error, 'error');
    });
}

function searchByNom() {
    const nom = document.getElementById('collab-nom').value;
    
    if (!nom) {
        showMessage('collab-message', 'Veuillez entrer un nom pour rechercher', 'error');
        return;
    }
    
    fetch(`${API_BASE_URL}/collaborateurs/nom/${nom}`)
    .then(response => response.json())
    .then(data => {
        displayCollaborateurs(data);
        if (data.length === 0) {
            showMessage('collab-message', 'Aucun collaborateur trouvé avec ce nom', 'error');
        }
    })
    .catch(error => {
        showMessage('collab-message', 'Erreur lors de la recherche: ' + error, 'error');
    });
}

window.onload = function() {
    loadDepartementOptions();
};
