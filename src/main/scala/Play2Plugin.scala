package com.github.play2war.ext

import com.dlecan.reflections.ReflectionJBoss7Vfs

import play.api._

class Play2JBoss7VfsReflectionPlugin(app: Application) extends Plugin {

    override def onStart() {

        Logger("play").info("JBoss VFS initialisation for Play applications...")

        ReflectionJBoss7Vfs.initVfs

        Logger("play").info("JBoss VFS initialisation for Play applications done")

    }

}