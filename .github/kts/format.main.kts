#!/usr/bin/env kotlin

@file:DependsOn("io.github.typesafegithub:github-workflows-kt:0.42.0")


import io.github.typesafegithub.workflows.actions.actions.CheckoutV3
import io.github.typesafegithub.workflows.actions.actions.SetupJavaV3
import io.github.typesafegithub.workflows.domain.RunnerType
import io.github.typesafegithub.workflows.domain.Workflow
import io.github.typesafegithub.workflows.domain.actions.CustomAction
import io.github.typesafegithub.workflows.domain.triggers.Push
import io.github.typesafegithub.workflows.dsl.workflow
import io.github.typesafegithub.workflows.yaml.writeToFile
import java.nio.file.Paths

public val workflowFormat: Workflow = workflow(
    name = "Format",
    on = listOf(Push()),
    sourceFile = Paths.get(".github/kts/format.main.kts"),
) {
    job(
        id = "formatting",
        runsOn = RunnerType.UbuntuLatest,
    ) {
        uses(
            name = "CheckoutV3",
            action = CheckoutV3(
                token = "${'$'}{{ secrets.PAT }}",
            ),
        )
        uses(
            name = "SetupJavaV3",
            action = SetupJavaV3(
                distribution = SetupJavaV3.Distribution.Custom("corretto"),
                javaVersion = "11",
            ),
        )
        run(
            name = "Execute Spotless",
            command = "./mvnw -B spotless:apply --file pom.xml",
        )
        uses(
            name = "GitAutoCommitActionV4",
            action = CustomAction(
                actionOwner = "stefanzweifel",
                actionName = "git-auto-commit-action",
                actionVersion = "v4",
                inputs = mapOf(
                    "commit_message" to "Apply formatter",
                )
            ),
        )
    }

}

workflowFormat.writeToFile(addConsistencyCheck = false)
