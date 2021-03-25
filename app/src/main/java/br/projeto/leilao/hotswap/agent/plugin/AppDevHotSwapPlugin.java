package br.projeto.leilao.hotswap.agent.plugin;

import org.hotswap.agent.annotation.Init;
import org.hotswap.agent.annotation.OnClassLoadEvent;
import org.hotswap.agent.annotation.Plugin;
import org.hotswap.agent.command.Scheduler;
import org.hotswap.agent.javassist.CannotCompileException;
import org.hotswap.agent.javassist.CtClass;
import org.hotswap.agent.javassist.CtConstructor;
import org.hotswap.agent.javassist.CtMethod;
import org.hotswap.agent.javassist.NotFoundException;
import org.hotswap.agent.logging.AgentLogger;
import org.hotswap.agent.util.PluginManagerInvoker;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;

@Plugin(name = "AppDevHotSwapPlugin", description = "Plugin para redefinição de classes e atualização do contexto da aplicação", testedVersions = {
		"" })
public class AppDevHotSwapPlugin {
	private static AgentLogger LOGGER = AgentLogger.getLogger(AppDevHotSwapPlugin.class);

	@Init
	ClassLoader appClassLoader;
	@Init
	Scheduler scheduler;
	private ApplicationContext applicationContext;

	@OnClassLoadEvent(classNameRegexp = "org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext")
	public static void register(CtClass clazz) throws NotFoundException, CannotCompileException {
		try {

			StringBuilder src = new StringBuilder("{");
			src.append(PluginManagerInvoker.buildInitializePlugin(AppDevHotSwapPlugin.class));
			src.append(PluginManagerInvoker.buildCallPluginMethod(AppDevHotSwapPlugin.class, "init", "this",
					ApplicationContext.class.getName()));
			src.append("}");
			CtClass c1 = clazz.getClassPool().get("org.springframework.beans.factory.support.DefaultListableBeanFactory");
			CtMethod m1 = c1.getDeclaredMethod("freezeConfiguration");
			m1.insertBefore("setAllowRawInjectionDespiteWrapping(true);");
			for (CtConstructor constructor : c1.getDeclaredConstructors()) {
				constructor.insertBeforeBody("setCacheBeanMetadata(false);");
			}
			for (CtConstructor constructor : clazz.getDeclaredConstructors()) {
				constructor.insertBeforeBody(src.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void init(ApplicationContext appCtx) {
		String[] names = null;
		try {
			LOGGER.info("");
			ApplicationContext teste = appCtx;
			LOGGER.info("");
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.applicationContext = null;
	}
}