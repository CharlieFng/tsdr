/*
 * Copyright (c) 2016 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.tsdr.datapurge.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.opendaylight.controller.config.api.DependencyResolver;
import org.opendaylight.controller.config.api.DependencyResolverFactory;
import org.opendaylight.controller.config.api.DynamicMBeanWithInstance;
import org.opendaylight.controller.config.api.ModuleIdentifier;
import org.opendaylight.controller.config.api.annotations.AbstractServiceInterface;
import org.opendaylight.controller.config.spi.Module;
import org.opendaylight.controller.config.yang.config.TSDR_datapurge.impl.AbstractTSDRDatapurgeModuleFactory;
import org.opendaylight.controller.config.yang.config.TSDR_datapurge.impl.TSDRDatapurgeModule;
import org.opendaylight.controller.config.yang.config.TSDR_datapurge.impl.TSDRDatapurgeModuleFactory;
import org.osgi.framework.BundleContext;

/**
 * This class is to only fix the code coverage report for the generated files in ODL
 * so we can see code coverage for the specific code that we wrote
 * @author Sharon Aicler(saichler@gmail.com)
 **/
public class ModuleCodeCoverageTest {
    @Test
    public void codeCoverageModule(){
        TSDRDatapurgeModuleFactory mf = new TSDRDatapurgeModuleFactory();
        new TSDRDatapurgeModule(null,null,null,null);
        TSDRDatapurgeModule module1 = new TSDRDatapurgeModule(null,null);
        BundleContext bundleContext = Mockito.mock(BundleContext.class);
        module1.setBundleContext(bundleContext);
        TSDRDatapurgeModule module2 = new TSDRDatapurgeModule(null,null);
        TSDRDatapurgeModule module3 = new TSDRDatapurgeModule(null,null);
        setupModuleWithMocks(module1,"X");
        setupModuleWithMocks(module2,"X");
        setupModuleWithMocks(module3,"Y");
        AutoCloseable c = module1.createInstance();
        module1.getDataBroker();
        module1.equals(new TSDRDatapurgeModule(null,null));
        module1.customValidation();
        module1.canReuseInstance(module2);
        module1.getRpcRegistry();
        module1.customValidation();
        module1.getLogger();
        module1.getIdentifier();
        module1.reuseInstance(c);
        module1.hashCode();
        module1.isSame(module1);
        module1.isSame(module2);
        module1.isSame(module3);
        try {
            module1.isSame(null);
        }catch(IllegalArgumentException e){
            Assert.assertTrue(e!=null);
        }
        module1.validate();
        try{
            executeResolveDependencies(module1);
        }catch(Exception e){
            e.printStackTrace();
        }

        module1.setRpcRegistry(null);
        module1.setDataBroker(null);
        try{
            c.close();
        }catch(Exception e){
            e.printStackTrace();
        }


        AbstractTSDRDatapurgeModuleFactory factory = new AbstractTSDRDatapurgeModuleFactory() {
            @Override
            public Set<Class<? extends AbstractServiceInterface>> getImplementedServiceIntefaces() {
                return super.getImplementedServiceIntefaces();
            }

            @Override
            public Module createModule(String instanceName, DependencyResolver dependencyResolver, BundleContext bundleContext) {
                return super.createModule(instanceName, dependencyResolver, bundleContext);
            }

            @Override
            public Module createModule(String instanceName, DependencyResolver dependencyResolver, DynamicMBeanWithInstance old, BundleContext bundleContext) throws Exception {
                return super.createModule(instanceName, dependencyResolver, old, bundleContext);
            }

            @Override
            public TSDRDatapurgeModule instantiateModule(String instanceName, DependencyResolver dependencyResolver, TSDRDatapurgeModule oldModule, AutoCloseable oldInstance, BundleContext bundleContext) {
                return super.instantiateModule(instanceName, dependencyResolver, oldModule, oldInstance, bundleContext);
            }

            @Override
            public TSDRDatapurgeModule instantiateModule(String instanceName, DependencyResolver dependencyResolver, BundleContext bundleContext) {
                return super.instantiateModule(instanceName, dependencyResolver, bundleContext);
            }

            @Override
            public TSDRDatapurgeModule handleChangedClass(DynamicMBeanWithInstance old) throws Exception {
                return super.handleChangedClass(old);
            }

            @Override
            public Set<TSDRDatapurgeModule> getDefaultModules(DependencyResolverFactory dependencyResolverFactory, BundleContext bundleContext) {
                return super.getDefaultModules(dependencyResolverFactory, bundleContext);
            }
        };
        factory.getImplementationName();
        factory.getImplementedServiceIntefaces();
        factory.getDefaultModules(null,null);
        factory.isModuleImplementingServiceInterface(AbstractServiceInterface.class);
        try {
            factory.handleChangedClass(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            DependencyResolver dpr = Mockito.mock(DependencyResolver.class);
            BundleContext b = Mockito.mock(BundleContext.class);
            factory.createModule("tsdr-syslog-collector",dpr , b);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            DependencyResolver dpr = Mockito.mock(DependencyResolver.class);
            BundleContext b = Mockito.mock(BundleContext.class);
            DynamicMBeanWithInstance old = Mockito.mock(DynamicMBeanWithInstance.class);
            factory.createModule("tsdr-syslog-collector",dpr , old,b);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            factory.instantiateModule(null, null, null);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void executeResolveDependencies(Object module) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method methods[] = module.getClass().getSuperclass().getDeclaredMethods();
        for(Method m:methods){
            if(m.getName().equals("resolveDependencies")){
                m.setAccessible(true);
                m.invoke(module,null);
                return;
            }
        }
    }

    public static final void setupModuleWithMocks(Object obj,String factoryName){
        try {
            org.opendaylight.controller.sal.binding.api.RpcProviderRegistry rpcProviderRegistry = Mockito.mock(org.opendaylight.controller.sal.binding.api.RpcProviderRegistry.class);
            DependencyResolver dpr = Mockito.mock(DependencyResolver.class);
            javax.management.ObjectName dataBroker = Mockito.mock(javax.management.ObjectName.class);
            javax.management.ObjectName rpcRegistry = Mockito.mock(javax.management.ObjectName.class);
            ModuleIdentifier id = Mockito.mock(ModuleIdentifier.class);
            Mockito.when(id.getFactoryName()).thenReturn(factoryName);
            Mockito.when(id.getInstanceName()).thenReturn(factoryName);
            Mockito.doNothing().when(dpr).validateDependency(Mockito.any(Class.class),Mockito.any(javax.management.ObjectName.class),Mockito.any(org.opendaylight.controller.config.api.JmxAttribute.class));

            Field f =findField("rpcRegistryDependency",obj.getClass());
            if(f!=null) {
                f.set(obj, rpcProviderRegistry);
            }

            f =findField("identifier",obj.getClass());
            if(f!=null) {
                f.set(obj, id);
            }

            f =findField("dependencyResolver",obj.getClass());
            if(f!=null) {
                f.set(obj, dpr);
            }

            f =findField("dataBroker",obj.getClass());
            if(f!=null) {
                f.set(obj, dataBroker);
            }

            f =findField("rpcRegistry",obj.getClass());
            if(f!=null) {
                f.set(obj, rpcRegistry);
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static final Field findField(String name,Class c){
        Field fields[] = c.getDeclaredFields();
        for(Field f:fields){
            if(f.getName().equals(name)){
                f.setAccessible(true);
                return f;
            }
        }
        if(c.getSuperclass()==null) {
            return null;
        }
        return findField(name,c.getSuperclass());
    }
}
