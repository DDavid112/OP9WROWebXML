<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match = "/">
        <html>
            <head>
                <meta charset="UTF-8"/>
            </head>
            <body>
                <h1>OP9WRO_orarend</h1>
                <table border ="4">
                    <th>Targy ID</th>
                    <th>Ora</th>
                    <th>Nap</th>
                    <th>Kezdet</th>
                    <th>Befejez</th>
                    <th>Helyszin</th>
                    <th>Oktato</th>
                    <th>Szak</th>

                    <xsl:for-each select="OP9WRO_orarend/ora">
                        <tr>
                            <td><xsl:value-of select = "@id"/></td>
                            <td><xsl:value-of select = "targy"/></td>
                            <td><xsl:value-of select = "idopont/nap"/></td>
                            <td><xsl:value-of select = "idopont/tol"/>:00</td>
                            <td><xsl:value-of select = "idopont/ig"/>:00</td>
                            <td><xsl:value-of select = "helyszin"/></td>
                            <td><xsl:value-of select = "oktato"/></td>
                            <td><xsl:value-of select = "szak"/></td>
                        </tr>
                    </xsl:for-each>

                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>