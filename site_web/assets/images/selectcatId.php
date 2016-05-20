<?php
$req = $bdd->prepare('SELECT * from Photo WHERE catId = ?');
$req->execute(array($_POST['ch']));
$count = $req -> rowCount();
echo $count.' photos trouvees dans la base de donnees <br/>';
while($data=$req->fetch())
{
echo '<a href="detail.php?photo='.$data['photoId'].'" >
	<img src="images/'.$data['nomFich'].'" alt="'.$data['description'].'" ></a>';
}
?>