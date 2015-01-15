<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>

    <xsl:template match="/">
        <HTML>
            <HEAD>
            </HEAD>
            <BODY>
                <xsl:apply-templates/>
            </BODY>
        </HTML>
    </xsl:template>


    <xsl:param name="mybreak"><![CDATA[<br/>]]></xsl:param>

    <xsl:template match="BODY">
        <xsl:value-of select="name"/>
        <xsl:value-of select="soil"/>
        <xsl:value-of select="origin"/>
        <xsl:value-of select="visual_parameters/stem_color"/>
        <xsl:value-of select="flower_color"/>
        <xsl:value-of select="average_size"/>
        <xsl:value-of select="temperature"/>
        <xsl:value-of select="photophilous"/>
        <xsl:value-of select="watering"/>
    </xsl:template>
</xsl:stylesheet>
