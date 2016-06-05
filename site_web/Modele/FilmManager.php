<?php
class FilmManager extends Model
{

	public function getInfoFilmByGenre($Genre)
	{
		$req=$this->executerRequete('SELECT * FROM Film WHERE LibelleGenre = ?', array($Genre));
		return $req->fetchAll();
	}
	
	public function getGenre()
	{
		$req=$this->executerRequete('SELECT * FROM Genre');
		return $req->fetchAll();
	}
	
	public function getInfoFilmByVisa($Visa)
	{
		$req=$this->executerRequete('SELECT * FROM Film Where NumVisa= ?',array($Visa));
		return $req->fetch();
	}
	
	public function getCastingByVisa($Visa)
	{
		$req=$this->executerRequete('SELECT * FROM Casting Where NumVisa = ?', array($Visa));
		return $req->fetchAll();
	}
	
	public function getAllFilms()
	{
		$req=$this->executerRequete('SELECT * from 	Film');
		return $req->fetchAll();
	}

	/*public function getLastFilm($numVIP)
	{
		$req=$this->executerRequete('SELECT * FROM Film WHERE annee = (SELECT Max(Film.annee) FROM Film, Casting WHERE Casting.numVIP = Casting.? AND Casting.NumVisa = Film.NumVisa)', array($numVIP)));
	}*/
}


?>
