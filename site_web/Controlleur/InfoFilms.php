<?php
include_once('functions/selected.php');
?>

<?php
	$baseCatwoman = new FilmManager();
	$Cat =  $baseCatwoman->getGenre();
	$i=2;
	ob_start();
	echo '<option value="1" '.$slct=isSelected(1).'>TOUS </option>';
		foreach($Cat as $key=>$value)
		{
			echo '<option value="'.$i.'" '.$slct=isSelected($i).'>'.$value['LibelleGenre'].' </option>';
			$i=$i+1;
			if(isSelected($i-1)=='selected')
			{
				echo 'HELLO WORLD';
				$TheCategorie = $value['LibelleGenre'];
			}
		}
	$option = ob_get_clean();

	//____________________________________________
	/*if(isset($_POST['genre']))
	{
		$InfoFilm= new FilmManager();
		if($_POST['Titre']!=Null)
		{
			echo 'Seulement la description de '.$_POST['Titre'].'</br>'.
			$unFilm = $InfoFilm -> getInfoFilmByTitle($_POST['Titre']);
		}else
		{
			echo 'tous les films';
			$tousLesFilms = $InfoFilm -> getAllFilms();
		}
		
	}*/
	//___________________________________________
	
	
	if(isset($_GET['Film']))
	{
		$InfoFilm= new FilmManager();
		
	}
	else if(isset($_POST['genre']))
	{
		$InfoFilm = new FilmManager();
		if($_POST['genre']=="1")
		{
			echo 'tous les films';
			$tousLesFilms = $InfoFilm -> getAllFilms();
		}else
		{
			$tousLesFilms = $InfoFilm -> getInfoFilmByGenre($TheCategorie);
		}
	}else

	
	
?>