

<?php
echo '
	<form method="post" action="index.php?page=ListeFilms">
		<label>Titre du Film recherché :</label> <input type="text" name="Titre" /></br>
		<label>Nom Réalisateur :</label> <input type="text" name="Realisateur" /></br>
		<label>Année de sortie :</label> <input type="text" name="annee" /></br>
		<label>Numero de Visa :</label> <input type="text" name="numVisa" /></br>
		<label>Nom d\'un acteur ayant participé au casting :</label> <input type="text" name="VIP" /></br>
		<input type="submit" value="rechercher"/>
	</form>
';
?>

<?php

if(isset($tousLesFilms))
{
	foreach($tousLesFilms as $key=>$value)
	{
		echo $value['Titre'].'</br>';
	}
}
?>