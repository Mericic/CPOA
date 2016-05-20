<?php
class FilmManager extends Model
{

	public function getInfoFilmByTitle($Titre)
	{
		$req=$this->executerRequete('SELECT * FROM Film');
		return $req->fetch();
	}
	
	public function getInfoFilmByNumVisa($NumVisa)
	{
		
	}
	
	public function getInfoFilmByCasting($numVIP)
	{
		
	}
	
	public function getAllFilms()
	{
		$req=$this->executerRequete('SELECT * from 	Film');
		return $req->fetchAll();
	}

}


?>
