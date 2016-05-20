<?php
$title='VIP';
$titlePage='Description VIP';
?>

<?php

ob_start();

echo '
	<form method="post" action="index.php?page=ficheVIP">
		<label>Nom du VIP recherché :</label> <input type="text" name="nomVIP" /></br>
		<input type="submit" value="rechercher"/>
	</form>';

if(isset($_POST['nomVIP']))
{
	if($data!=FALSE)
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
	else if($data==FALSE)
	{
			echo '<p>Nom et prenom inconnus</p>';
	}
}


$content=ob_get_clean();
include_once('layout.php');

?>