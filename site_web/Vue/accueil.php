<?php
$title='VOICELA';
$titlePage='Bienvenue sur Voicela';
?>

<?php
ob_start();
echo 'page d\'accueil. <a href="index.php?page=ListeFilms" >liste films</a>';

$content=ob_get_clean();
include_once('layout.php');
?>