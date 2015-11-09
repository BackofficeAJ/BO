package sn.hubsocial.avisjournaux.backoffice.client.dataGrid;

import gwt.material.design.client.custom.MaterialCheckBoxCell;
import gwt.material.design.client.ui.MaterialImage;
import sn.hubsocial.avisjournaux.backoffice.client.DTO.AnnonceDTO;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SelectionModel;

public class AnnonceDataGrid  extends Composite {

	private static MaterialDataGridUiBinder uiBinder = GWT.create(MaterialDataGridUiBinder.class);

	interface MaterialDataGridUiBinder extends UiBinder<Widget, AnnonceDataGrid> {
	}

	private List<AnnonceDTO> orders = new ArrayList<AnnonceDTO>();

	private DataGrid<AnnonceDTO> dataGrid;
	private ListDataProvider<AnnonceDTO> ModeleAnnonceProvider;
	private ListHandler<AnnonceDTO> sortDataHandler;
	private final ProvidesKey<AnnonceDTO> KEY_PROVIDER = new ProvidesKey<AnnonceDTO>() {

		@Override
		public Object getKey(AnnonceDTO item) {
			return item.getId();
		}
	};

	private final SelectionModel<AnnonceDTO> selectionModel = new MultiSelectionModel<AnnonceDTO>(KEY_PROVIDER);

	private AnnonceDTO ModeleAnnonce;

	@UiField
	SimplePanel gridPanel , pagerPanel ;

	public AnnonceDataGrid() {
		initWidget(uiBinder.createAndBindUi(this));
		setGrid();
	}

	private void setGrid() {
		dataGrid = createDatagrid();
		gridPanel.setWidget(dataGrid);
		refreshData();
	}

	private void refreshData() {
		ModeleAnnonceProvider.setList(new ArrayList<AnnonceDTO>());
		getAllAnnonce();
	}

	private DataGrid<AnnonceDTO> createDatagrid() {

		this.sortDataHandler = new ListHandler<AnnonceDTO>(new ArrayList<AnnonceDTO>());
		// CHECKBOX
		Column<AnnonceDTO, Boolean> checkColumn = new Column<AnnonceDTO, Boolean>(new MaterialCheckBoxCell()) {
			@Override
			public Boolean getValue(AnnonceDTO object) {
				boolean value = selectionModel.isSelected(object);
				
				return value;
			}
		};
		
		FieldUpdater<AnnonceDTO, Boolean> checkColumnFU = new FieldUpdater<AnnonceDTO, Boolean>() {

            @Override
            public void update(int index, AnnonceDTO object, Boolean value) {
                selectionModel.setSelected(object, value);
            }
        };
        checkColumn.setFieldUpdater(checkColumnFU);

        // IMAGE
        Column<AnnonceDTO, MaterialImage> colfichier = new Column<AnnonceDTO, MaterialImage>(new MaterialImageCell()) {
            @Override
            public MaterialImage getValue(AnnonceDTO object) {
                
            	MaterialImage img = new MaterialImage();
            	img.setUrl(object.getFichier());
            	img.setWidth("40px");
            	img.setHeight("40px");
            	//SET IMAGE TO CIRCLE
            	//img.setType("circle");
                return img;
            }
            
        };
        
        // TITRE
		TextColumn<AnnonceDTO> colTitre = new TextColumn<AnnonceDTO>() {
			@Override
			public String getValue(AnnonceDTO object) {

				return object.getTitre();
			}
		};
		colTitre.setSortable(true);
		sortDataHandler.setComparator(colTitre, new Comparator<AnnonceDTO>() {

			@Override
			public int compare(AnnonceDTO o1, AnnonceDTO o2) {

				return o1.getTitre().compareTo(o2.getTitre());
			}
		});

		// STRUCTURE
		TextColumn<AnnonceDTO> colStructure = new TextColumn<AnnonceDTO>() {
			@Override
			public String getValue(AnnonceDTO object) {

				return object.getStructure();
			}
		};
		colStructure.setSortable(true);
		sortDataHandler.setComparator(colStructure, new Comparator<AnnonceDTO>() {

			@Override
			public int compare(AnnonceDTO o1, AnnonceDTO o2) {

				return o1.getStructure().compareTo(o2.getStructure());
			}
		});

		// RESUME
		TextColumn<AnnonceDTO> colResume = new TextColumn<AnnonceDTO>() {
			@Override
			public String getValue(AnnonceDTO object) {

				return object.getResume();
			}
		};
		colResume.setSortable(true);
		sortDataHandler.setComparator(colResume, new Comparator<AnnonceDTO>() {

			@Override
			public int compare(AnnonceDTO o1, AnnonceDTO o2) {

				return o1.getResume().compareTo(o2.getResume());
			}
		});
		
		// TYPE QUOTIDIEN
				TextColumn<AnnonceDTO> colType = new TextColumn<AnnonceDTO>() {
					@Override
					public String getValue(AnnonceDTO object) {

						return object.getTypequot();
					}
				};
				colType.setSortable(true);
				sortDataHandler.setComparator(colType, new Comparator<AnnonceDTO>() {

					@Override
					public int compare(AnnonceDTO o1, AnnonceDTO o2) {

						return o1.getTypequot().compareTo(o2.getTypequot());
					}
				});
				
				// LOCCALITE
				TextColumn<AnnonceDTO> colLocalite = new TextColumn<AnnonceDTO>() {
					@Override
					public String getValue(AnnonceDTO object) {

						return object.getlocalite();
					}
				};
				colLocalite.setSortable(true);
				sortDataHandler.setComparator(colLocalite, new Comparator<AnnonceDTO>() {

					@Override
					public int compare(AnnonceDTO o1, AnnonceDTO o2) {

						return o1.getlocalite().compareTo(o2.getlocalite());
					}
				});

		// ACTION BUTTON
//		Column<OrderDTO, MaterialButton> showLogBtnColumn = new Column<OrderDTO, MaterialButton>(new MaterialButtonCell()) {
//            @Override
//            public MaterialButton getValue(OrderDTO object) {
//                
//                MaterialButton mb = new MaterialButton("Show log", "blue", "light");
//                mb.setIcon("mdi-action-polymer");
//                mb.setIconPosition("left");
//                mb.getElement().getStyle().setProperty("display", "inline-flex");
//                return mb;
//            }
//            
//        };
        
//        showLogBtnColumn.setFieldUpdater(new FieldUpdater<OrderDTO, MaterialButton>() {
//			
//			@Override
//			public void update(int index, OrderDTO object, MaterialButton value) {
//				MaterialToast.alert(object.getName());
//			}
//		});

		final DataGrid<AnnonceDTO> dataGrid = new DataGrid<AnnonceDTO>(100, KEY_PROVIDER);
		dataGrid.setSize("100%", "40vh");

		dataGrid.addColumn(checkColumn, SafeHtmlUtils.fromSafeConstant("<br/>"));
		dataGrid.setColumnWidth(checkColumn, "50px");
		dataGrid.addColumn(colfichier, "Fichier");
		dataGrid.addColumn(colTitre, "Titre");
		dataGrid.addColumn(colResume, "Resume");
		dataGrid.addColumn(colStructure, "Structure");
		dataGrid.addColumn(colType, "Type Quotidien");
		dataGrid.addColumn(colLocalite, "Localite");
		
		//dataGrid.addColumn(showLogBtnColumn, "Action");

		dataGrid.setStyleName("striped responsive-table");

		SimplePager.Resources pagerResources = GWT.create(SimplePager.Resources.class);
		SimplePager pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0, true);
		pager.setDisplay(dataGrid);
		pagerPanel.add(pager);

		ModeleAnnonceProvider = new ListDataProvider<AnnonceDTO>();
		ModeleAnnonceProvider.addDataDisplay(dataGrid);
		dataGrid.addColumnSortHandler(sortDataHandler);

		return dataGrid;

	}

	private void getAllAnnonce() {
		orders.add(new AnnonceDTO("logo.jpg","titre","Resume", "Structure",  "Parue dans", "Dakar"));
//		orders.add(new OrderDTO(1, "Karah","http://lorempixel.com/50/50/people?1", "Asus", "Php 23000"));
		
		ModeleAnnonceProvider.setList(orders);
		sortDataHandler.setList(ModeleAnnonceProvider.getList());
	}

	public AnnonceDTO getModeleAnnonce() {
		return ModeleAnnonce;
	}

	public void setModeleAnnonce(AnnonceDTO ModeleAnnonce) {
		this.ModeleAnnonce = ModeleAnnonce;
	}
	
//	@UiHandler("rbDefault")
//	void onDefault(ClickEvent e){
//		dataGrid.setStyleName("responsive-table");
//	}
//	
//	@UiHandler("rbBordered")
//	void onBordered(ClickEvent e){
//		dataGrid.setStyleName("bordered responsive-table");
//	}
//	
//	@UiHandler("rbStriped")
//	void onStriped(ClickEvent e){
//		dataGrid.setStyleName("striped responsive-table");
//	}
//
//	@UiHandler("rbHoverable")
//	void onHoverable(ClickEvent e){
//		dataGrid.setStyleName("hoverable responsive-table");
//	}
//	
//	@UiHandler("btnSource")
//	void onSource(ClickEvent e){
//		Window.open(IMaterialConstants.LINK_DATAGRID, "" , "_blank");
//	}
}