<?php
include_once('functions/selected.php');
?>

<?php
	$baseCatwoman = new FilmManager();
	$Cat =  $baseCatwoman->getGenre();
	$i=1;
	
	
	ob_start();
	echo '<option value="1" '.$slct=isSelected($i).'>TOUS </option>';
		foreach($Cat as $key=>$value)
		{
			$i=$i+1;
			echo '<option value="'.$i.'" '.$slct=isSelected($i).'>'.$value['LibelleGenre'].' </option>';
			
			if(isSelected($i-1)=='selected')
			{
				echo 'HELLO WORLD';
				$TheCategorie = $value['LibelleGenre'];
			}
		}
	$option = ob_get_clean();

	
	
	
	if(isset($_GET['Film']))
	{
		$InfoVIP = new VIPManager();
		$InfoFilm= new FilmManager();
		if($_GET['Film']!=NULL)
		{
			$unFilm= $InfoFilm -> getInfoFilmByVisa($_GET['Film']);
			$Casting = $InfoFilm -> getCastingByVisa($_GET['Film']);
			$i=0;
			foreach($Casting as $key=>$value)
			{
				if($value['Role']=='realisateur')
				{
					$realisateur= $InfoVIP -> getInfoVIPbynum($value['numVIP']);
				}else
				{
					$i=$i+1;
					$InfoCasting[$i] = array($InfoVIP -> getInfoVIPbynum($value['numVIP']));
				}
				
			}
		}
	}
	else if(isset($_POST['genre']))
	{
		$InfoFilm = new FilmManager();
		if($_POST['genre']=="1")
		{
			$tousLesFilms = $InfoFilm -> getAllFilms();
		}else
		{
			$tousLesFilms = $InfoFilm -> getInfoFilmByGenre($TheCategorie);
		}
	}
?>