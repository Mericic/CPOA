<?php
	class UserManager extends Model{
		
		
		
		public function CreateUser($Login, $Pass, $Nom, $Email)
		{
			$testLogin = $this->executerRequete('SELECT COUNT(*) AS logtest FROM Utilisateur WHERE Login = ?', array($Login));
			$testMail = $this->executerRequete('SELECT COUNT(*) AS Mailtest FROM Utilisateur WHERE Email = ?', array($Email));
			$Log = $testLogin->fetch();
			$Mail = $testMail->fetch();
			if($Log['logtest'] > 0)
			{
				if($Mail['Mailtest'] > 0)
				{
					return 'Login et Mail déjà pris';
				}
				return 'Login déjà pris';
			}else if($Mail['Mailtest'] > 0)
			{
				return 'Mail déjà pris';
			}else{
				$req = 'INSERT INTO Utilisateur VALUES (?, ?, ?, ?)';
				$res=$this->executerRequete($req, array($Login, $Pass, $Nom, $Email));
				return 'True';
			}
			
		}
		
		public function AccessUser($Login, $Pass)
		{
			$testLogin = $this->executerRequete('SELECT COUNT(*) AS logtest FROM Utilisateur WHERE Login = ?', array($Login));
			$testPass = $this->executerRequete('SELECT COUNT(*) AS Passtest FROM Utilisateur WHERE 	Pass = ?', array($Pass));
			$Log = $testLogin->fetch();
			$Passt = $testPass->fetch();
			if($Log['logtest'] > 0)
			{
				if($Passt['testPass'] > 0)
				{
					return 'Login et mdp faux';
				}
				return 'Login faux';
			}else if($Passt['testPass'] > 0)
			{
				return 'Mail faux';
			}else{
				return 'True';
			}
			
		}
		
		public function UserInfo($Login)
		{
			
		}
	}

?>