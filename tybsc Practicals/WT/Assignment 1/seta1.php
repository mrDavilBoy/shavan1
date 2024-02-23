<?php

session_start();

if (!isset($_COOKIE['page_count']))
{
    setcookie('page_count',1,time()+3600);
}

if (!isset($_SESSION['page_count']))
{
    $_SESSION['page_count']=1;
}

$_COOKIE['page_count']++;
$_SESSION['page_count']++;

echo "This page has been accessed ".$_COOKIE['page_count']."times (cookie) and".$_SESSION['page_count']."times(session)";

?>
