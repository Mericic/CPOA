<?php
$title='. . .';
$titlePage='Utilisateur Crée. Bienvenue';
?>

<?php
ob_start();
	
	$Connexion = new UserManager();
	$Creation = $Connexion->CreateUser($_POST['Login'], $_POST['Pass'], $_POST['Nom'], $_POST['Email']);
	if($Creation == 'True')
	{
		$Resultat = 'Creation d\'un nouveau compte réussi';
	}else
	{
		$Resultat= $Creation.' <a href="index.php?connexion">Réessayer</a>';
	}
	
	header('Location: index.php');
	exit(1000);


?> 

<?php

echo '<p>'.$Resultat.'</p>';


$content=ob_get_clean();
include_once('layout.php');
?>