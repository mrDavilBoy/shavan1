<?php

$dom = new DomDocument();
$dom->load("Movie.xml");
echo "<h2>Name of the Movies</h2>";
$Mname=$dom->getElementsByTagName("MovieTitle");

foreach ($Mname as $m)
{
        echo "<b>$m->textContent<b><br><br>";
}

?>
