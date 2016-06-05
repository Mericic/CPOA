<?php
$title='VIP';
$titlePage='recherche de Film';
?>

<?php
ob_start();

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
	if($_GET['Film']!=NULL)
	{
		echo $unFilm['Titre'];
		if(isset($realisateur))
			echo '<p>realisé par '.$realisateur['PrenomVIP'].' '.$realisateur['NomVIP'].'</p>';
		echo '<p>Acteurs: </p>';
		foreach($InfoCasting as $key=>$value)
		{
			foreach($value as $key=>$valeur)
			{	
			echo '<p> '.$valeur['PrenomVIP'].' '.$valeur['NomVIP'].' dans le rôle de ';
			foreach($Casting as $key=>$Cast)
			{
			if($Cast['numVIP']==$valeur['numVIP'])
				{
					echo $Cast['Role'];
				}
			}
			echo' </p>
			<form method="post" action="index.php?page=ficheVIP">
				<input type="hidden" name="nomVIP" value="'.$valeur['NomVIP'].'">
				<input type="submit" value="Voir"/>
			</form>';
			//echo '
				//<a href="index.php?page=ficheVIP">Profil</a> </p>';
			}
		}
		echo '<p>Résumé</p>'.$unFilm['Resume'];
	}
}else
{
	if(isset($tousLesFilms))
	{
		foreach($tousLesFilms as $key=>$value)
		{
			echo '<table class="tabfilm">	
							<tr>					
								<td>	
									'.$value['Titre'].'
								</td>
								<td>
									
								</td>  
							</tr>
							
							
								
							<tr>
								<td colspan = "2">
								<a href="index.php?page=ListeFilms&Film='.$value['NumVisa'].'">Voir</a>		</td>
							</tr>
						</table>';
		}
	}
}

$content=ob_get_clean();
include_once('layout.php');
?>