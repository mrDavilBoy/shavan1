<?php
$xml = simplexml_load_file("Book.xml");

foreach ($xml->book as $bk)
{
        echo "Book No=$bk->bookno"."<br>";
        echo "Book Name=$bk->bookname"."<br>";
        echo "Author Name=$bk->authorname"."<br>";
        echo "Price=$bk->price"."<br>";
        echo "Year=$bk->year"."<br>";
}
?>
