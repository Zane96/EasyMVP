# EasyMVP
在安卓上运用的MVP模式开发框架。A framework for MVP pattern in android.

##将activity,fragment, adapter作为presenter的mvp开发框架。

###可以看看这篇文章对这种模式的理解:[《MVP模式的一种新的尝试》](https://github.com/bboyfeiyu/android-tech-frontier/tree/master/androidweekly/%E4%B8%80%E7%A7%8D%E5%9C%A8android%E4%B8%AD%E5%AE%9E%E7%8E%B0MVP%E6%A8%A1%E5%BC%8F%E7%9A%84%E6%96%B0%E6%80%9D%E8%B7%AF)
###以及框架的具体介绍文章:[《MVP开发框架的第一次尝试》](http://zane96.github.io/2016/01/28/MVP%E5%BC%80%E5%8F%91%E6%A1%86%E6%9E%B6%E7%9A%84%E4%B8%80%E6%AC%A1%E5%B0%9D%E8%AF%95%E2%80%94%E2%80%94EasyMVP/)

###重复依赖：butterkinfe。
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
	        compile 'com.github.Zane96:EasyMVP:v1.2.4'
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
	
