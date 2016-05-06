##EasyMVP
在安卓上运用的MVP模式开发框架。A framework for MVP pattern in android.

与传统MVP开发模式相反，EasyMVP是将activity,fragment, adapter作为presenter的mvp开发框架。

###了解更多
+ 可以看看这篇文章对这种模式的理解:[《MVP模式的一种新的尝试》](https://github.com/bboyfeiyu/android-tech-frontier/tree/master/androidweekly/%E4%B8%80%E7%A7%8D%E5%9C%A8android%E4%B8%AD%E5%AE%9E%E7%8E%B0MVP%E6%A8%A1%E5%BC%8F%E7%9A%84%E6%96%B0%E6%80%9D%E8%B7%AF)
+ 以及框架的具体介绍文章:[《MVP开发框架的第一次尝试》](http://zane96.github.io/2016/01/28/MVP%E5%BC%80%E5%8F%91%E6%A1%86%E6%9E%B6%E7%9A%84%E4%B8%80%E6%AC%A1%E5%B0%9D%E8%AF%95%E2%80%94%E2%80%94EasyMVP/)

###重复依赖
**butterknofe** 
	
###添加依赖：
gradle:
**Add it in your root build.gradle at the end of repositories:**
```
allprojects {
		  repositories {
			  ...
			  maven { url "https://jitpack.io" }
		  }
	  }
```
**Add the dependency:**
```
	  dependencies {
	        compile 'com.github.Zane96:EasyMVP:v1.3.1'
	  }
```

###使用：
**View**:
```
  public class MainListView extends BaseViewImpl
```
**Presenter**
```
  public class MainActivity extends BaseActivityPresenter<MainListView>
```
**ViewHolder**
```
  public class MainListViewHolder extends BaseListViewHolderImpl<Bean>
```
**Adapter**
```
  public class MyRecycleviewAdapter extends BaseListAdapterPresenter<Bean>
```
**Model**
```
  public class RecycleviewData implements IListModel
```

###BaseListAdapterPresenter和BaseListViewHolderImpl的介绍
viewHolder与Adapter解耦的部分请看上述博客。将viewHolder于adapter分离，viewholder去管理item的view，给adapter瘦身。
**更新介绍**：
+ 数据对象的集合全部在base类中进行管理，所有的数据操作都已经在BaseAdapterPresenter里面定义好了。开发者只需要在适配器里面调用继承过来的mDatas对象就可以操作数据了。具体可以看源码。
+ 解决特殊情况下一个recycleview需要展示不同数据源数据（多个model）的情况。例如一个recycleview的前5个item要展示Model A的数据，后5个item要展示Model B的数据。这样开发者需要写一个公共ModelC类，并且持有A,B的对象。并且这个C类实现框架IListModel接口，实现getViewType()（根据父类里面的之类实例对象是否为空来返回相应的type）方法。因为C类是适配器的类泛型，所以在getItemViewType方法里面去调用C里面的getViewType方法。但是以后可能会把这项工作放到框架总去做，因为现在没有太多的考虑head和foot的问题。A,B类是要继承C类，并且在将C类的数据集合生成的时候，必须要用相应的子类对象作为父类引用的指向对象，不然在viewHolder里面父类强转子类对象会报错哦（java基础）。具体实现请看demo中的代码。
	

###版本更新介绍:
+ v1.3.1:主要修改在**BaseListAdapter**中：
	1. 开发者需要在adapter里面实现setHeadNum()和setFootNum()方法来告诉框架你添加的headhe foot的数量。
	2. 主要的数据源均在框架里面进行管理，开发者直接调用框架中的对集合操作的方法去操作mDatas变量。开发者当然也可以自定义数据变量。
+ v.1.3.0:强制使activity拥有提供context到view中的函数。因为有时候view的使用必须用到activity类型的context。提供的过程由框架内部完成，开发者只需要get,set就行。比如启动activity，启动Toast都可以在view中实现，解决java类作为View的一个很麻烦的问题。
	
