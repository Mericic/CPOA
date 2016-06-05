<?php
$title='VIP';
$titlePage='Description VIP';
?>

<?php

ob_start();

echo '
	<form method="post" action="index.php?page=ficheVIP">
		<label>Nom du VIP recherché :</label> <input type="text" name="nomVIP" />
		<label >Tous afficher</label><input checked	 type="checkbox" name="Tous" value="oui"/>
		<input type="submit" value="rechercher"/>
	</form>';

if(isset($_POST['nomVIP']))
{
	if($data!=FALSE)
	{
		
		if(isset($MessageMariage))
		{
			echo "Infos VIP: ";
			//Nom prenom birthdate
			echo '<p>Nom: '.$data['NomVIP'].' Prenom : '.$data['PrenomVIP'].' Date de Naissance : '.$data['DateNaissance'].'</p></br>';
			
			//images relatives à cette star
			foreach($dataImg as $key=>$value)
			{
				echo '<img src="assets/images/'.$value['NomFichier'].'" alt="'.$value['date'].' ">';
			}
			//Mariage
			echo $MessageMariage;
		}
		
		
		
	
	}

	else if(isset($_POST['Tous']) && $_POST['Tous']=="oui" )
	{
		if($_POST['nomVIP']==NULL)
		{
			echo '<div class="surliste">';
					foreach($dataTous as $Tous)
					{//rajouter image perso							<!--<img src="assets/images/'.$value['NomFichier'].'" alt="'.$value['date'].' ">-->

						echo '
						<div class="liste">
							<p>	'.$Tous['NomVIP'].', '.$Tous['PrenomVIP'].' --'.$Tous['DateNaissance'].'</p> 
							<p>	Ce VIP ne joue dans aucun Film		</p>
										<form method="post" action="index.php?page=ficheVIP">
														<input type="hidden" name="nomVIP" value="'.$Tous['NomVIP'].'">
														<input type="submit" value="Voir"/>
										</form>	
							
						</div>
					';
					}
					foreach($dataTousFilm as $TousFilm)
					{
							echo '<div class="liste">
								<p>'.$TousFilm['NomVIP'].', '.$TousFilm['PrenomVIP'].' --'.$TousFilm['DateNaissance'].'</p>
								<p>					Dernier Film '.$TousFilm['Titre'].'</p>
								
												<form method="post" action="index.php?page=ficheVIP">
													<input type="hidden" name="nomVIP" value="'.$TousFilm['NomVIP'].'">
													<input type="submit" value="Voir"/>
												</form>
											
									</div>
							';
					
					}
			echo '</div>';	
				
		}
	
	}else if($data==FALSE)
	{
			echo '<p>Nom et prenom inconnus</p>';
	}
}

$content=ob_get_clean();
include_once('layout.php');

?>