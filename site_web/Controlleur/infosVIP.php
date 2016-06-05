<?php
//

	$Info = new VIPManager();
	$Image = new PhotoManager();
	$Film = new FilmManager();
	$dataTousFilm= $Info->getAllVIPFilm();
	$dataTous = $Info->getAllVIP();

	if(isset($_POST['nomVIP']))
	{
		//Informations sur le VIP (nom, prenom, date de naissance)
		$data= $Info -> getInfoVIP($_POST['nomVIP']);
		
		/*condtions à rajouter:
		recherche avec prenom
		recherche avec nom prenom
		recherche avec prenom nom
		if($data == NULL)
		{
			recherche getInfoVIPbyfirstname()
		}else if($data == NULL)
		{
			recherche getInfoVIPbyPN() Prenom puis nom
		}else if($data==NULL)
		{
			recherche get infoVIPbyNP() Nom puis prenom
		}
		*/
		//Photos trouvées avec le VIP dessus.
		$numVIP=$data['numVIP'];
		$dataImg= $Image -> getPhoto($numVIP);
		//Infos Mariage
		$dataMariage = $Info ->getMariage($numVIP);	

		
		
		ob_start();
			foreach($dataMariage as $key=>$value)
			{
				if($value['DateDivorce']==NULL)
				{
					if($value['numVIPConjoint']!=$numVIP)
					{	
						$Conjoint = $Info -> getInfoVIPbynum($value['numVIPConjoint']);
					}else
					{
						$Conjoint = $Info -> getInfoVIPbynum($value['numVIP']);

					}
					echo 'Marié(e) avec '.$Conjoint['PrenomVIP'].' '.$Conjoint['NomVIP'].' depuis le '.$value['dateMariage'].' à '.$value['lieuMariage'].' </br>';
				}else
				{
					if($value['numVIPConjoint']!=$numVIP)
					{
						$Conjoint = $Info -> getInfoVIPbynum($value['numVIPConjoint']);
					}else
					{
						$Conjoint = $Info -> getInfoVIPbynum($value['numVIP']);

					}
					echo 'Etait Marié(e) avec '.$Conjoint['PrenomVIP'].' '.$Conjoint['NomVIP'].' le '.$value['dateMariage'].' à '.$value['lieuMariage'].', divorcé le '.$value['DateDivorce'].' </br>';
				}
			}
		$MessageMariage=ob_get_clean();
		//$nomConjoint = $Info -> getNomVIP($Conjoint['numVIPConjoint']);

	}

	
	
?>