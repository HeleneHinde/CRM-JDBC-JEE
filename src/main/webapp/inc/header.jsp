<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8" />
    <title>${pageTitle != null ? pageTitle : 'CRM - Gestion des clients'}</title>
    <link type="text/css" rel="stylesheet" href="inc/style.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <header>
        <nav>
            <ul class="nav-menu">
                <li><a href="/crm/createCustomer">Créer un client</a></li>
                <li><a href="/crm/createOrder">Créer une commande</a></li>
                <li><a href="/crm/createUser">Créer un utilisateur</a></li>
            </ul>
        </nav>
    </header>
    
    <main>
