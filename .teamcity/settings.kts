import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2022.10"

project {

    vcsRoot(GHmain)
//    vcsRoot(TempEmpty)
//    vcsRoot(TempTt)

    buildType(BuildConf)
}

object BuildConf : BuildType({
    name = "build conf"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        maven {
            name = "mvn tst"
            goals = "clean test"
        }
    }
})

object GHmain : GitVcsRoot({
    name = "GH-main"
    url = "https://github.com/daimLiat/simple-JUnit.git"
    branch = "dslBranch1"
//    branch = "${DslContext.getParameter("branch")}"
    authMethod = password {
        userName = "daimliat"
        password = "credentialsJSON:e7a5d319-8444-4a52-8646-e138f18e407f"
    }
})

//object TempEmpty : GitVcsRoot({
//    name = "temp_Empty"
//    url = "https://github.com/daimLiat/generic-empty.git"
//    branch = "main"
//    authMethod = password {
//        userName = "daimliat"
//        password = "credentialsJSON:e7a5d319-8444-4a52-8646-e138f18e407f"
//    }
//})
//
//object TempTt : GitVcsRoot({
//    name = "temp_TT"
//    url = "https://github.com/daimLiat/test-task.git"
//    branch = "main"
//    authMethod = password {
//        userName = "daimliat"
//        password = "credentialsJSON:e7a5d319-8444-4a52-8646-e138f18e407f"
//    }
//})

