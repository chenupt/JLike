package me.risky.jlike.controller;

import me.risky.jlike.R;
import me.risky.jlike.base.AbsBaseItemController;
import me.risky.jlike.base.ImageLoaderHelper;
import me.risky.jlike.base.OnItemClickListener;
import me.risky.jlike.bean.MyTagHandler;
import me.risky.jlike.bean.MyTagHandler.OnLinkClickListener;
import me.risky.jlike.bean.WelfareDetail;
import me.risky.jlike.util.Constants;
import me.risky.library.base.ImageUtil;

import org.androidannotations.annotations.EBean;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

@EBean
public class NewsDetailController extends AbsBaseItemController{
	private final static String TAG = "NewsDetailController";
	
	private ViewHolder holder;
	private ImageLoaderHelper imageLoaderHelper;
	
	public NewsDetailController(Context context) {
		super(context);
		imageLoaderHelper = new ImageLoaderHelper(context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent, Object item) {
		final WelfareDetail detail = (WelfareDetail) item;
		Log.d("Controller", position + "position");
		if (null == convertView) {
			holder = new ViewHolder();
			switch(detail.getType()){
			case Constants.DEF_WELFARE_DETAIL.TITLE:
				convertView = layoutInflater.inflate(R.layout.list_item_detail_head, null);
				holder.textView = (TextView) convertView.findViewById(R.id.title);
				break;
			case Constants.DEF_WELFARE_DETAIL.CONTENT:
				convertView = layoutInflater.inflate(R.layout.list_item_detail_content, null);
				holder.textView = (TextView) convertView.findViewById(R.id.textView);
				break;
			case Constants.DEF_WELFARE_DETAIL.IMG:
				convertView = layoutInflater.inflate(R.layout.list_item_detail_img, null);
				holder.img = (ImageView) convertView.findViewById(R.id.imageView);
				holder.imgTag = (TextView) convertView.findViewById(R.id.tag);
				break;
			case Constants.DEF_WELFARE_DETAIL.TAG:
				convertView = layoutInflater.inflate(R.layout.list_item_detail_tag, null);
				holder.textView = (TextView) convertView.findViewById(R.id.textView);
				break;
			default:
				break;
			}
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		if (null != item) {
			final int p = position;
			switch(detail.getType()){
			case Constants.DEF_WELFARE_DETAIL.IMG:
				Log.d("display", detail.getImgSrc());
				if(ImageUtil.isGIF(detail.getImgSrc())){
					holder.imgTag.setVisibility(View.VISIBLE);
				}else{
					holder.imgTag.setVisibility(View.GONE);
				}
				holder.img.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						if(onClickListener != null){
							onClickListener.onItemClick(p, detail);
						}
					}
				});
				imageLoaderHelper.display(detail.getImgSrc(), holder.img);
				break;
			case Constants.DEF_WELFARE_DETAIL.TITLE:
				holder.textView.setText(Html.fromHtml(detail.getTitle(), null, new MyTagHandler()));
				break;
			case Constants.DEF_WELFARE_DETAIL.CONTENT:
				holder.textView.setMovementMethod(LinkMovementMethod.getInstance());
				holder.textView.setText(Html.fromHtml(detail.getContent(), null, new MyTagHandler()));
				
				//设置超链接点击事件
				CharSequence text = holder.textView.getText();
				if (text instanceof Spannable) {  
		            int end = text.length();
		            Spannable sp = (Spannable) text;  
		            URLSpan[] spans = sp.getSpans(0, end, URLSpan.class);  
		            SpannableStringBuilder style = new SpannableStringBuilder(text);  
		            style.clearSpans();// should clear old spans  
		            for (URLSpan span : spans) {  
		            	MyTagHandler.MyClickableSpan mySpan = new MyTagHandler().new MyClickableSpan(span.getURL());
		            	mySpan.setOnClickListener(onLinkClickListener);
		                style.setSpan(mySpan, sp.getSpanStart(span), sp.getSpanEnd(span), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);  
		            }  
		            holder.textView.setText(style); 
		        }
				break;
			case Constants.DEF_WELFARE_DETAIL.TAG:
				holder.textView.setText(Html.fromHtml(detail.getTag(), null, new MyTagHandler()));
				break;
			default:
				break;
			}
		}
		return convertView;
	}
	
	
	@Override
	public int getItemViewType(int position, Object item) {
		int result = 0;
		WelfareDetail detail = (WelfareDetail) item;
		switch(detail.getType()){
		case Constants.DEF_WELFARE_DETAIL.TITLE:
			result = 0;
			break;
		case Constants.DEF_WELFARE_DETAIL.CONTENT:
			result = 1;
			break;
		case Constants.DEF_WELFARE_DETAIL.IMG:
			result = 2;
			break;
		case Constants.DEF_WELFARE_DETAIL.TAG:
			result = 3;
			break;
		default:
			break;
		}
		return result;
	}

	@Override
	public int getViewTypeCount() {
		return 4;
	}




	private class ViewHolder {
		 TextView textView;
	     ImageView img;
	     TextView imgTag;
	}
	
	
	private OnItemClickListener<WelfareDetail> onClickListener;
	
	public void setOnItemClickListener(OnItemClickListener<WelfareDetail> onClickListener){
		this.onClickListener = onClickListener;
	}
	
	private OnLinkClickListener onLinkClickListener;
	
	public void setOnLinkClickListener(OnLinkClickListener onLinkClickListener){
		this.onLinkClickListener = onLinkClickListener;
	}
	
}
