/**
 * <h1>Adatelérési réteg, SQL lekérdezések, adatbázis kapcsolódás.</h1>
 * MYSQL és XML adatok kezelése.
 *
 * MYSQL Tábla:
 *
 * CREATE TABLE IF NOT EXISTS `aram_szolgaltatok` ( `id` int(11) NOT NULL
 * AUTO_INCREMENT COMMENT 'Az áram szolgáltatókhoz tartozó egyedi azonosító,
 * elsődleges kulcs.', `megnevezes` text COLLATE utf8_hungarian_ci NOT NULL
 * COMMENT 'A kereskedő ill. szolgáltató szöveges megnevezése',
 * `megnevezes_rovid` varchar(10) COLLATE utf8_hungarian_ci NOT NULL COMMENT 'A
 * kereskedő ill. szolgáltató szöveges megnevezése rövidített formában', `cim`
 * text COLLATE utf8_hungarian_ci NOT NULL COMMENT 'A kereskedő ill. szolgáltató
 * székhelyének címe', `uf_online` text COLLATE utf8_hungarian_ci NOT NULL
 * COMMENT 'Link az online ügyfélszolgálatra', `uf` text COLLATE
 * utf8_hungarian_ci NOT NULL COMMENT 'Offline ügyfélszolgálati
 * elérhetőség(ek))', `leiras` text COLLATE utf8_hungarian_ci NOT NULL COMMENT
 * 'A kereskedő ill. szolgáltatóhoz kapcsolódó, bővebb szöveges leírás', `link`
 * text COLLATE utf8_hungarian_ci NOT NULL COMMENT 'A kereskedő ill. szolgáltató
 * weboldalára mutató link', `kep` text COLLATE utf8_hungarian_ci NOT NULL
 * COMMENT 'A kereskedő ill. szolgáltató szerveren tárolt logóképének url címe',
 * `kapcsolattarto_mail` text COLLATE utf8_hungarian_ci NOT NULL, `torolt`
 * smallint(1) NOT NULL COMMENT 'A rekord aktív-inaktív állapotának jelzésére
 * szolgáló kétállapotú jelző. Értéke 0 vagy 1.', PRIMARY KEY (`id`) )
 * ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci AUTO_INCREMENT=1
 * ;
 *
 * @author Pál Miklós DS710T
 * @version 1.0
 */
package com.ds710t.szolgaltatok.model;
