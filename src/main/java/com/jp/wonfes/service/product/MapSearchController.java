package com.jp.wonfes.service.product;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.junit.experimental.theories.Theories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.common.base.Strings;
import com.jp.wonfes.common.Takuban;
import com.jp.wonfes.service.dao.common.Dealer;
import com.jp.wonfes.service.dao.common.DealerExample;
import com.jp.wonfes.service.dao.common.mapper.DealerMapper;
import com.jp.wonfes.service.product.form.DelaerSearchResultForm;
import com.jp.wonfes.service.product.form.MapSearchForm;
import com.jp.wonfes.service.product.form.UsrDetailFavProducts;
import com.jp.wonfes.service.product.form.UsrFavProducts;

@Controller
public class MapSearchController {
	
	@Autowired
	private DealerMapper dealerMapper;

	/**
	 * 初期表示
	 * 別画面から遷移してきた場合に、当メソッドを呼び出す
	 * <p>遷移元画面
	 * <ul>
	 * <li>アカウント一覧画面
	 * <li>ディーラ情報画面
	 * </ul>
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/mp/show", method = RequestMethod.POST)
	public String initMap(@ModelAttribute MapSearchForm form, HttpSession session, Model model) {
		
		String usrId = (String) session.getAttribute("s_loginId");
		String dealerId=form.getDealerId();
		
		/**
		 * TDOO usrIdでusr_detail_fav_productsテーブルに検索し、取得した結果から
		 * 最大のディーラを取得し「showHole」をキーにmodelに設定すること
		 * mockとして固定で8を設定
		 */
		model.addAttribute("usrId", usrId);
		if(dealerId==null || dealerId.equals("")) {
			// 最大のディーラを設定する
			model.addAttribute("showHole", 6);
		}else {
			Dealer d = dealerMapper.selectByPrimaryKey(Integer.parseInt(dealerId));
			String takuban=d.getTakuban();
			Takuban t= new Takuban(takuban);
			model.addAttribute("showHole", t.getKo());
			model.addAttribute("takuban", t.getTakubanPadding());
		}
		return "mapForDojin";
	}
	
	/**
	 * URLで指定したホールを表示する
	 * 
	 * <p>実際には表示させたいホール情報を画面に渡し、画面側で条件分岐して表示するJSPを正業している
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/mp/show/{showHole}", method = RequestMethod.GET)
	public String showMap(@PathVariable("showHole") Integer showHole, HttpSession session,Model model) {
		String usrId = (String) session.getAttribute("s_loginId");
		model.addAttribute("usrId", usrId);
		model.addAttribute("showHole", showHole);
		return "mapForDojin";
	}
	
	/**
	 * DBから取得したお気に入りDealer情報をJSON形式で返却する
	 * 検索条件の指定あり
	 * @param usrId ユーザID
	 * @return お気に入りDealer情報JSON
	 */
	@RequestMapping(value = "/mp/getFavDealer/{usrId}", method = RequestMethod.GET)
	@ResponseBody
	public UsrFavProducts getFavDealer(@PathVariable String usrId) {
		// TODO DBへの問い合わせは後で行う、モックで値を作成
		UsrFavProducts mockList = this.getMock4UsrFavProducts();
		return mockList;
	}
	
	
	
	
	// -----------------------------------------------------------------------------------------------
	// mock
	// -----------------------------------------------------------------------------------------------
	/**
	 * mock
	 * 
	 * @return favディーラJSON
	 */
	private UsrFavProducts getMock4UsrFavProducts() {
		UsrFavProducts u = new UsrFavProducts();
		u.setFav(this.getMock4UsrDetailFavProducts());
		return u;
	}
	/**
	 * mock
	 * 
	 * @return usrIdで検索した結果FormのListを返却する
	 */
	private List<UsrDetailFavProducts> getMock4UsrDetailFavProducts() {
		final UsrDetailFavProducts f1 = new UsrDetailFavProducts() {
			{this.setName("あかちょむ");this.setTakuban("08-22-04");}
		};
		final UsrDetailFavProducts f2 = new UsrDetailFavProducts() {
			{this.setName("Piyopiyo堂");this.setTakuban("07-30-07");}
		};
		List<UsrDetailFavProducts> arrayList = new ArrayList<UsrDetailFavProducts>();
		arrayList.add(f1);arrayList.add(f2);
		return arrayList;
	}
}
