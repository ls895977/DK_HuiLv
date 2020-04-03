package com.daikuanhuilv.dk_huilv.ui;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.daikuanhuilv.dk_huilv.R;
import com.daikuanhuilv.dk_huilv.ui.adapter.GridImageAdapter;
import com.daikuanhuilv.dk_huilv.ui.bean.ActionpublicCurrencyBean;
import com.daikuanhuilv.dk_huilv.ui.bean.FullyGridLayoutManager;
import com.daikuanhuilv.dk_huilv.ui.bean.PublicHuiluyjfkBean;
import com.daikuanhuilv.dk_huilv.ui.http.ApiConstant;
import com.daikuanhuilv.dk_huilv.ui.view.Auth;
import com.google.gson.Gson;
import com.gyf.barlibrary.ImmersionBar;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.permissions.RxPermissions;
import com.luck.picture.lib.tools.PictureFileUtils;
import com.lykj.aextreme.afinal.common.BaseActivity;
import com.lykj.aextreme.afinal.utils.Debug;
import com.lykj.aextreme.afinal.utils.MyToast;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;
import com.qiniu.android.common.FixedZone;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.Configuration;
import com.qiniu.android.storage.KeyGenerator;
import com.qiniu.android.storage.Recorder;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UploadManager;

import org.json.JSONObject;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 我的=问题反馈
 */
public class Act_ProblemFeedback extends BaseActivity {
    @BindView(R.id.recycler)
    RecyclerView recyclerView;
    @BindView(R.id.content)
    EditText content;
    @BindView(R.id.etTelephone)
    EditText etTelephone;
    @BindView(R.id.shuliang)
    TextView shuliang;
    @BindView(R.id.ProblemFeedback_commit)
    TextView ProblemFeedback_commit;

    @Override
    public int initLayoutId() {
        return R.layout.act_problemfeedback;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this).statusBarDarkFont(true).init();
    }

    private UploadManager uploadManager;
    private Recorder recorder;
    private KeyGenerator keyGen;
    private String upToken;

    @Override
    public void initView() {
        hideHeader();
        //绑定初始化ButterKnife
        ButterKnife.bind(this);
        Configuration config = new Configuration.Builder()
                .chunkSize(512 * 1024)        // 分片上传时，每片的大小。 默认256K
                .putThreshhold(1024 * 1024)   // 启用分片上传阀值。默认512K
                .connectTimeout(10)           // 链接超时。默认10秒
                .useHttps(true)               // 是否使用https上传域名
                .responseTimeout(60)          // 服务器响应超时。默认60秒
                .recorder(null)           // recorder分片上传时，已上传片记录器。默认null
                .recorder(recorder, keyGen)   // keyGen 分片上传时，生成标识符，用于片记录器区分是那个文件的上传记录
                .zone(FixedZone.zoneAs0)        // 设置区域，指定不同区域的上传域名、备用域名、备用IP。
                .build();
        // 重用uploadManager。一般地，只需要创建一个uploadManager对象
        uploadManager = new UploadManager(config);
        Auth auth = Auth.create(accessKey, secretKey);
        upToken = auth.uploadToken(bucket);
    }

    String bucket = "ynimage001";
    String accessKey = "lb5ntuPzvl6BoSqL5yato8Pqwg5WXoPHGVzTktIt";
    String secretKey = "7i3g_SDTFCvJ-TYs3FBfCJJtki8Rp2hYfNVIK908";
    GridImageAdapter adapter;
    private int themeId;

    @Override
    public void initData() {
        themeId = R.style.picture_default_style;
        FullyGridLayoutManager manager = new FullyGridLayoutManager(Act_ProblemFeedback.this, 4, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        adapter = new GridImageAdapter(Act_ProblemFeedback.this, onAddPicClickListener);
        adapter.setList(selectList);
        adapter.setSelectMax(4);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new GridImageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                if (selectList.size() > 0) {
                    LocalMedia media = selectList.get(position);
                    String pictureType = media.getPictureType();
                    int mediaType = PictureMimeType.pictureToVideo(pictureType);
                    switch (mediaType) {
                        case 1:
                            // 预览图片 可自定长按保存路径
                            //PictureSelector.create(MainActivity.this).themeStyle(themeId).externalPicturePreview(position, "/custom_file", selectList);
                            PictureSelector.create(Act_ProblemFeedback.this).themeStyle(themeId).openExternalPreview(position, selectList);
                            break;
                        case 2:
                            // 预览视频
                            PictureSelector.create(Act_ProblemFeedback.this).externalPictureVideo(media.getPath());
                            break;
                        case 3:
                            // 预览音频
                            PictureSelector.create(Act_ProblemFeedback.this).externalPictureAudio(media.getPath());
                            break;
                    }
                }
            }

            @Override
            public void onDelateBack(int position) {
            }
        });
        // 清空图片缓存，包括裁剪、压缩后的图片 注意:必须要在上传完成后调用 必须要获取权限
        RxPermissions permissions = new RxPermissions(this);
        permissions.request(Manifest.permission.WRITE_EXTERNAL_STORAGE).subscribe(new Observer<Boolean>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(Boolean aBoolean) {
                if (aBoolean) {
                    PictureFileUtils.deleteCacheDirFile(Act_ProblemFeedback.this);
                } else {
                    Toast.makeText(Act_ProblemFeedback.this,
                            getString(R.string.picture_jurisdiction), Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        });
        content.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                shuliang.setText(content.getText().toString().length() + "/500");
                ProblemFeedback_commit.setSelected(etStatus());
            }
        });
        etTelephone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ProblemFeedback_commit.setSelected(etStatus());
            }
        });
    }

    private List<LocalMedia> selectList = new ArrayList<>();
    private int chooseMode = PictureMimeType.ofImage();
    private GridImageAdapter.onAddPicClickListener onAddPicClickListener = () -> {
        // 进入相册 以下是例子：不需要的api可以不写
        PictureSelector.create(this)
                .openGallery(chooseMode)
                .maxSelectNum(1)// 最大图片选择数量
                .theme(themeId)// 主题样式设置 具体参考 values/styles   用法：R.style.picture.white.style
                .minSelectNum(1)// 最小选择数量
                .imageSpanCount(4)// 每行显示个数
                .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                .selectionMode(PictureConfig.MULTIPLE)
                .isCamera(true)
                .compress(true)// 是否压缩
                .synOrAsy(true)//同步true或异步false 压缩 默认同步
                .glideOverride(250, 250)// glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
                .freeStyleCropEnabled(true)// 裁剪框是否可拖拽
                .minimumCompressSize(100)// 小于100kb的图片不压缩
                .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    List<LocalMedia> choseList = PictureSelector.obtainMultipleResult(data);
                    for (int i = 0; i < choseList.size(); i++) {
                        selectList.add(choseList.get(i));
                    }
                    adapter.setList(selectList);
                    adapter.notifyDataSetChanged();
                    ProblemFeedback_commit.setSelected(etStatus());
                    break;
            }
        }
    }

    @Override
    public void updateUI() {

    }

    @Override
    public void onNoInterNet() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.min_problemfeedback_back, R.id.ProblemFeedback_commit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.min_problemfeedback_back:
                finish();
                break;
            case R.id.ProblemFeedback_commit:
                if (selectList.size() == 0) {
                    MyToast.show(context, "请选择一张照片！");
                    return;
                }
                if (TextUtils.isEmpty(content.getText().toString())) {
                    MyToast.show(context, "请填写您要反馈的信息！");
                    return;
                }
                if (TextUtils.isEmpty(etTelephone.getText().toString())) {
                    MyToast.show(context, "请填写您的电话，微信，QQ或邮箱！");
                    return;
                }
                commit();
                break;
        }
    }

    private String picture = "";

    public void commit() {
        for (int i = 0; i < selectList.size(); i++) {
            String token = upToken;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String key1 = "icon_" + 0 + "" + sdf.format(new Date());
            uploadManager.put(selectList.get(i).getPath(), key1, token,
                    (key, info, res) -> {
                        //res包含hash、key等信息，具体字段取决于上传策略的设置
                        if (info.isOK()) {
                            picture = key;
                            OkGo.<String>get(ApiConstant.ROOT_URL + ApiConstant.publicHuiluyjfk)
                                    .params("content", content.getText().toString())
                                    .params("picture", picture)
                                    .params("telephone", etTelephone.getText().toString())
                                    .tag(this)
                                    .execute(new StringCallback() {
                                        @Override
                                        public void onSuccess(Response<String> response) {
                                            loding.dismiss();
                                            String data = response.body();//这个就是返回来的结果
                                            Gson gson = new Gson();
                                            PublicHuiluyjfkBean bena = gson.fromJson(data, PublicHuiluyjfkBean.class);
                                            if (bena.getStatus() == 1) {
                                                MyToast.show(getApplicationContext(), "提交成功！");
                                                finish();
                                            }
                                        }
                                        @Override
                                        public void onError(Response<String> response) {
                                            loding.dismiss();
                                            if (response.body() == null || response.body().equals("null")) {
                                                MyToast.show(getApplicationContext(), "获取超时！");
                                            }
                                            super.onError(response);
                                        }
                                    });
                        } else {
                            Toast.makeText(getApplicationContext(), "图片上传失败，请检查网络连接", Toast.LENGTH_SHORT).show();
                        }
                        Log.e("qiniu", key + ",\r\n " + info + ",\r\n " + res);
                    }, null);
        }
    }

    public boolean etStatus() {
        if (content.getText().toString().length() > 0) {
        } else {
            return false;
        }
        if (etTelephone.getText().toString().length() > 0) {
        } else {
            return false;
        }
        if (selectList.size() == 1) {
        } else {
            return false;
        }
        return true;
    }
}


