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
	if($_GET['page']=='accueil')//page d'accueil
	{
		echo 'accueil';
		include_once('Vue/accueil.php');
	}else if($_GET['page']=='ficheVIP')//fiche de description d'un VIP
	{
		echo'fiche vip';
		include_once('Controlleur/infosVIP.php');
		include_once('Vue/ficheVIP.php');
	}else if($_GET['page']=='Creation')//Creation de compte
	{
		echo 'creat compte';
		include_once('Creation.php');
	}else if($_GET['page']=='Connexion')//Connection à un compte utilisateur
	{
		echo 'co';
		include_once('Vue/FirtConnexion.php');
	}else if($_GET['page']=='Photo')//Visionnage des photos présentes sur la base64_decode
	{
		echo 'photo';
		include_once('Vue/album.php');
	}else if($_GET['page']=='Film')//affichage de la description d'un film
	{
		echo'film';
	}elseif($_GET['page']=='ListeFilms')
	{
		echo'liste films';
		include_once('Controlleur/InfoFilms.php');
		include_once('Vue/ListeFilms.php');
	}
}else
{
	echo 'choix défaut: accueil';
	include_once('Vue/accueil.php');
}




?>