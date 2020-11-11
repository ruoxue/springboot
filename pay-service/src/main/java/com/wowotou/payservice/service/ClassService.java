package com.wowotou.payservice.service;

import com.wowotou.model.entity.ClazzModel;
import com.wowotou.payservice.annotation.APIShow;
import com.wowotou.payservice.factory.ServiceFactory;
import com.wowotou.payservice.order.IOrderService;
import org.bson.codecs.pojo.ClassModel;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.stereotype.Service;

import java.lang.reflect.Modifier;
import java.util.*;

@Service
public class ClassService {
    public   List<ClazzModel> getSonClass() {
        try {
            return getSubClasses(IOrderService.class, IOrderService.class.getPackage().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }


    private   <E>List<ClazzModel> getSubClasses(final Class<E> parentClass,
                                                       final String packagePath) throws Exception {
        List<ClazzModel> classModelList=new ArrayList<>();

        final ClassPathScanningCandidateComponentProvider provider =
                new ClassPathScanningCandidateComponentProvider(
                false);
        provider.addIncludeFilter(new AssignableTypeFilter(parentClass));
        final Set<BeanDefinition> components = provider
                .findCandidateComponents(packagePath);
      //  final List<Map<String, String>> subClasses = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        for (final BeanDefinition component : components) {
            final Class<E> cls = (Class<E>) Class.forName(component
                    .getBeanClassName());
            if (Modifier.isAbstract(cls.getModifiers())) {
                continue;
            }
            if (!cls.getSuperclass().getName() .equals( IOrderService.class.getName())) {
                // continue;
            }

            ServiceFactory.getInstance().createnOrderService(cls.getName()).getClass().getAnnotations();

            APIShow annotation = cls.getAnnotation(APIShow.class);
            Service service=cls.getAnnotation(Service.class);
            String s = "";
            if (annotation != null) {
                s = annotation.value();
                System.out.println(s);

            }

           // map.put(cls.getName(), s);
            ClazzModel classModel=new ClazzModel();
            classModel.set_id(cls.getName());
            classModel.setName(s);
            classModel.setServiceName(service.value());
            classModelList.add(classModel);

           // subClasses.add(map);
        }
        return classModelList;
    }
}
