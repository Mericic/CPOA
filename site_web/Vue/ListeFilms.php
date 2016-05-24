

<?php
echo '
	<form method="post" action="index.php?page=ListeFilms">
		<select name="genre">
				'.$option.'
	</select>

		<input type="submit" value="rechercher"/>
	</form>
';
?>

<?php
if(isset($_GET['Film']))
{
	if(isset($unFilm))
	{
		echo $unFilm['Titre'].'realisé par '.$unFilm['NumVisa'];
	}
}else{
if(isset($tousLesFilms))
{
	foreach($tousLesFilms as $key=>$value)
	{
		echo '<a href="index.php?page=ListeFilms&Film='.$value['NumVisa'].'">'.$value['Titre'].'</a></br>';//faire tableau avec réalisateur et bout du résumé
	}
}
}