package io.freefair.plantuml.tasks


import io.freefair.plantuml.PlantUmlPreparedRender
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class PlantUmlIOTask extends DefaultTask {
    private Map<File, PlantUmlPreparedRender> inputPreparedRenderMap = [:]

    void addPreparedRender(PlantUmlPreparedRender preparedRender) {
        inputPreparedRenderMap << [(preparedRender.input): preparedRender]
    }

    @TaskAction
    void execute() {
        inputPreparedRenderMap.each { entry ->
            println("${project.relativePath(entry.value.input).replace('\\', '/')},${project.relativePath(entry.value.output).replace('\\', '/')}")
        }
    }
}
