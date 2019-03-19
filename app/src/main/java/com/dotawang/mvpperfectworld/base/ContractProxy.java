package com.dotawang.mvpperfectworld.base;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * description:mvp框架核心代理类,主要通过反射获取类下泛型,拿到presenter model类
 * 且提供方法 绑定和解绑view model ,m_objects是通过class和实例的对应关系实现bindModel(Class clzz, BasePresenter presenter)和unbindModel(Class clzz, BasePresenter presenter)
 */
public class ContractProxy {
    private static final ContractProxy m_instance = new ContractProxy();

    public static ContractProxy getInstance() {
        return m_instance;
    }

    private ContractProxy() {
        m_objects = new HashMap<>();
    }

    private Map<String, Map<Class, Object>> m_objects;

    /**
     * IPresenter
     * 通过反射, 获得定义Class时声明的父类的泛型参数的类型.
     *
     * @param clazz clazz The class to introspect
     * @param index the Index of the generic ddeclaration,start from 0.
     * @return the index generic declaration, or Object.class if cannot be
     * determined
     */
    @SuppressWarnings("unchecked")
    public static Class<BasePresenter> getPresnterClazz(final Class clazz, final int index) {

        //返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type。
        Type genType = clazz.getGenericSuperclass();

        if (!(genType instanceof ParameterizedType)) {
            return BasePresenter.class;
        }
        //返回表示此类型实际类型参数的 Type 对象的数组。
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        if (index >= params.length || index < 0) {
            return BasePresenter.class;
        }
        if (!(params[index] instanceof Class)) {
            return BasePresenter.class;
        }
        return (Class) params[index];
    }

    public static Class getFirstGrnericClazz(final Class clazz) {

        //返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type。
        Type genType = clazz.getGenericSuperclass();

        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }
        //返回表示此类型实际类型参数的 Type 对象的数组。
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        return (Class) params[0];
    }

    /**
     * Model
     * 通过反射, 获得定义Class时声明的父类的泛型参数的类型.
     *
     * @param clazz clazz The class to introspect
     * @param index the Index of the generic ddeclaration,start from 0.
     * @return the index generic declaration, or Object.class if cannot be
     * determined
     */
    @SuppressWarnings("unchecked")
    public static Class<IModel> getModelClazz(final Class clazz, final int index) {

        //返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type。
        Type genType = clazz.getGenericSuperclass();

        if (!(genType instanceof ParameterizedType)) {
            return IModel.class;
        }
        //返回表示此类型实际类型参数的 Type 对象的数组。
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

        if (index >= params.length || index < 0) {
            return IModel.class;
        }
        if (!(params[index] instanceof Class)) {
            return IModel.class;
        }
        return (Class) params[index];
    }

    /**
     * 获取presenter
     *
     * @param holderName
     * @param clzz
     * @param <T>
     * @return
     */
    public <T> T presenter(String holderName, Class clzz) {
        Object o = m_objects.get(holderName);
        BasePresenter presenter = null;
        try {
            if (o != null && o instanceof BasePresenter) {
                presenter = (BasePresenter) o;
            } else {
                presenter = ((BasePresenter) clzz.newInstance());
                HashMap<Class, Object> map = new HashMap<>();
                map.put(clzz, presenter);
                m_objects.put(holderName, map);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (T) presenter;
    }

    /**
     * 进行初始化
     *
     * @param clss
     */
    public Object initInstance(Class clss) {
        try {
            return clss.newInstance();
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 绑定 View
     *
     * @param presenter
     * @param <V>
     * @return
     */
    public <V> V bindView(IView view, BasePresenter presenter) {
        if (view != presenter.getView()) {
            if (presenter.getView() != null) {
                presenter.detachView();
            }
            presenter.attachView(view);
        }
        return (V) view;
    }

    // 解除绑定 移除map
    public void unbindPresenter(String holderName, BasePresenter p) {
        m_objects.remove(holderName);
        p = null;
    }

    // 初始化model add map
    public <M> M bindModel(String holderName, Class clzz, BasePresenter presenter) {
        Object o = m_objects.get(holderName);
        IModel model = null;
        try {
            if (o != null && o instanceof IModel) {
                model = (IModel) o;
            } else {
                model = ((IModel) clzz.newInstance());
                HashMap<Class, Object> map = new HashMap<>();
                map.put(clzz, model);
                m_objects.put(holderName, map);
            }
        } catch (Exception e) {
        }
        if (model != presenter.getModel()) {
            if (presenter.getModel() != null) {
                presenter.detachModel();
            }
            presenter.attachModel(model);
        }
        return (M) model;
    }

    // 解除绑定

    public void unbindView(IView view, BasePresenter presenter) {
        if (view != null && view == presenter.getView()) {
            presenter.detachView();
        }
    }

    // 解除绑定 移除map
    public void unbindModel(String holderName, Class clzz, BasePresenter presenter) {
        if (m_objects.containsKey(holderName)) {
            try {
                HashMap map = (HashMap) m_objects.get(holderName);
                IModel model = (IModel) map.get(clzz);
                if (model != null && model == presenter.getModel()) {
                    presenter.detachModel();
                    m_objects.remove(holderName);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
