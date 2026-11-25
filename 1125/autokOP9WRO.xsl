<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match = "/">
        <html>
            <head>
                <meta charset="UTF-8"/>
            </head>
            <body>
                <h1>autok_OPWR9O</h1>
                <table border ="4">
                    <th>Rendszamok:</th>
                    <th>Tipus</th>

                    <xsl:for-each select="autok/auto">
                        <tr>
                            <td><xsl:value-of select = "@rsz"/></td>
                            <td><xsl:value-of select = "tipus"/></td>

                        </tr>
                    </xsl:for-each>

                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>