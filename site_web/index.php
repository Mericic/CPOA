<?php
include_once("Modele/Model.php");
include_once("Modele/VIPManager.php");
include_once("Modele/PhotoManager.php");
include_once("Modele/FilmManager.php");
Session_name('p1406760') ;
Session_start() ;
//error_reporting(0);
?>


<?php

if(isset($_GET['page']))
{
	switch($_GET['page'])
	{
		case'accueil'://page d'accueil
			include_once('Vue/accueil.php');
			break;
	
		case'ficheVIP'://fiche de description d'un VIP
			include_once('Controlleur/infosVIP.php');
			include_once('Vue/ficheVIP.php');
			break;
			
		case'Creation'://Creation de compte
			include_once('Creation.php');
			break;
			
		case'Connexion'://Connection à un compte utilisateur
			echo 'co';
			include_once('Vue/FirtConnexion.php');
			break;
			
		case'Photo'://Visionnage des photos présentes sur la base64_decode
			echo 'photo';
			include_once('Vue/album.php');
			break;
			
		case'ListeFilms':
			include_once('Controlleur/InfoFilms.php');
			include_once('Vue/ListeFilms.php');
			break;
	}
}else
{
	include_once('Vue/accueil.php');
}




?>