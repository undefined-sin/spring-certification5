package org.study.spring5.container.extension;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.TypedStringValue;
import org.study.spring5.StudyBean;

import java.util.Base64;
import java.util.Iterator;
import java.util.function.Consumer;

public class PasswordDecryptorBeanFactoryPostProcessor extends StudyBean implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory bf) throws BeansException {
        Iterator<String> it = bf.getBeanNamesIterator();
        it.forEachRemaining(consumeBeanDefinition(bf));
    }

    private Consumer<String> consumeBeanDefinition(ConfigurableListableBeanFactory bf) {
        return name -> {
            if (bf.containsBeanDefinition(name)) {
                BeanDefinition def = bf.getBeanDefinition(name);
                if (Credentials.class.getName().equals(def.getBeanClassName())) {
                    log("Credentials definition found: " + def);
                    processBeanDefinition(def);
                }
            }
        };
    }

    private void processBeanDefinition(BeanDefinition def) {
        MutablePropertyValues pvs = def.getPropertyValues();
        String decoded = null;
        log(def.toString());
        for (PropertyValue pv : pvs) {
            if (pv.getName().equals("secret")) {
                TypedStringValue strType = (TypedStringValue) pv.getValue();
                String value = Credentials.normalizeString(strType.getValue());
                log("Decrypting password: %s", value);
                decoded = new String(Base64.getDecoder().decode(value));
            }
        }
        if (decoded != null) {
            pvs.add("password", decoded);
        }
    }
}
