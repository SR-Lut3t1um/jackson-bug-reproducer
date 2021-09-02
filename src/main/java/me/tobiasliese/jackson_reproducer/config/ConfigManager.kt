package me.tobiasliese.jackson_reproducer.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import java.io.IOException
import java.util.*

object ConfigManager {
    @JvmStatic
    lateinit var config: Config

    @get:Throws(IOException::class)
    private val defaultConfig: String
        get() =
            """
testData:
    - hello: "World :)"
"""

    init {
        val mapper = ObjectMapper(YAMLFactory()).registerKotlinModule()
        mapper.enable(SerializationFeature.INDENT_OUTPUT)
        try {
            config = mapper.readValue(defaultConfig, Config::class.java)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}