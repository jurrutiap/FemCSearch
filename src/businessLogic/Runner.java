package businessLogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import data.*;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import ui.AddBookFrame;
import ui.BookProfile;
import ui.LoginFrame;
import ui.MenuFrame;
import ui.ProfileFrame;
import ui.RegisterFrame;
import ui.ResultsFrame;
import ui.SearchFrame;

/**
 * @author daportelac@unal.edu.co
 * @author jurrutia@unal.edu.co
 * 
 */

public class Runner {

	public static void main(String[] args) {

		ContentsReader dt = new ContentsReader("repository");
		User_Reader ur = new User_Reader("persons");
		VerificadorIdentidad autenticador = new VerificadorIdentidad();
		Repository cb = new Repository(dt.getColections());
		Base_Personas usuarios = new Base_Personas(ur.getUsuarios());

		LoginFrame f1 = new LoginFrame("Login");

		f1.getLogin().addActionListener(new ActionListener() { // LOGIN
			public void actionPerformed(ActionEvent e) {
				Controller.loginMethod(f1, autenticador, usuarios);

				if (autenticador.isLoginStatus()) {
					f1.getWrongUserLabel().setVisible(false);
					f1.clearFields();
					f1.dispose();
					MenuFrame f2 = new MenuFrame("Menu");
					if (!autenticador.getUsuarioActivo().isAdmin()) {
						f2.notAdminUser();
					}

					f2.getEndSession().addActionListener(new ActionListener() { // SIGN OUT
						public void actionPerformed(ActionEvent e) {
							autenticador.setLoginStatus(false);
							autenticador.setUsuarioActivo(null);
							Controller.changeView(f2, f1);
						}
					});

					f2.getProfile().addActionListener(new ActionListener() { // PROFILE
						public void actionPerformed(ActionEvent e) {
							String name = autenticador.getUsuarioActivo().getNombre();
							String id = autenticador.getUsuarioActivo().getId();
							String picturePath = autenticador.getUsuarioActivo().getPicturePath();
							ProfileFrame f3 = new ProfileFrame("Profile", name, id, picturePath,
									Controller.upMyResources(autenticador.getUsuarioActivo()));
							f2.dispose();

							f3.getBackButton().addActionListener(new ActionListener() { // BACK
								public void actionPerformed(ActionEvent e) {
									Controller.changeView(f3, f2);
								}
							});
						}
					});
					f2.getSearch().addActionListener(new ActionListener() { // SEARCH BOOK
						public void actionPerformed(ActionEvent en) {
							String actionCommand = en.getActionCommand();
							if (actionCommand.equals("Search")) {
								SearchFrame f4 = new SearchFrame("Search");
								f2.dispose();

								f4.getSearchResource().addActionListener(new ActionListener() { // SEARCH
									public void actionPerformed(ActionEvent e) {
										ResultsFrame f5 = new ResultsFrame("Results", Controller.searchMethod(f4, cb));
										f4.dispose();

										f5.getSelectResource().addActionListener(new ActionListener() { // SELECT
											public void actionPerformed(ActionEvent en) {
												int ind = f5.getList().getSelectedIndex();
												if (f5.getList().isSelectedIndex(ind)) {
													Resources b = (Resources) f5.getList().getModel().getElementAt(ind);
													String nam = b.getName();
													String aut = b.getAuthor();
													String pdate = b.getPublicationDate();
													String codeRes = b.getId();
													String ima = b.getImage();
//													                                                                                                          
													BookProfile f7 = new BookProfile(nam, aut, pdate, codeRes, ima);
													f5.dispose();

													f7.getGetBookButton().addActionListener(new ActionListener() { //GET BOOK
														public void actionPerformed(ActionEvent e) {
															JFrame f = new JFrame();
															if (b.getNumberItems() == 0) {
																JOptionPane.showMessageDialog(f,
																		"There is no available items.");
															} else {
																autenticador.getUsuarioActivo().getPersonResources()
																		.add(b);
																b.numItemsMinusOne();
																JOptionPane.showMessageDialog(f,
																		"Resource succesfuly booked.");
															}
														}
													});
													//
													f7.getAddCommentButton().addActionListener(new ActionListener() { //ADD COMMENT
														public void actionPerformed(ActionEvent e) {
															final JFileChooser fc = new JFileChooser();
															int returnVal = fc.showOpenDialog(fc);

															if (returnVal == JFileChooser.APPROVE_OPTION) {

																File file = fc.getSelectedFile();
																b.setCommentsFile(file);

															}
														}
													});

													f7.getSeeCommentsButton().addActionListener(new ActionListener() { //SEE COMMENTS
														public void actionPerformed(ActionEvent e) {

															try {
																String path = b.getCommentsFile().getAbsolutePath();
																Controller.openWebpage(path);
															} catch (Exception ex) {
																JFrame f = new JFrame();
																JOptionPane.showMessageDialog(f,
																		"There are no comments.");
															}

														}
													});

													f7.getBackButton().addActionListener(new ActionListener() { //BACK
														public void actionPerformed(ActionEvent e) {
															Controller.changeView(f7, f2);
														}
													});
												}
											}
										});

										f5.getBackButton().addActionListener(new ActionListener() { // BACK
											public void actionPerformed(ActionEvent e) {
												Controller.changeView(f5, f4);
											}
										});
									}
								});

								f4.getBackButton().addActionListener(new ActionListener() { // BACK
									public void actionPerformed(ActionEvent e) {
										Controller.changeView(f4, f2);
									}
								});
							}
						}
					});
					f2.getAddBook().addActionListener(new ActionListener() { // ADD BOOK
						public void actionPerformed(ActionEvent en) {
							AddBookFrame f6 = new AddBookFrame("Add book");
							f2.dispose();

							f6.getAdd().addActionListener(new ActionListener() { // ADD BOOK
								public void actionPerformed(ActionEvent e) {
									f6.resetWrong();
									if (Controller.registerVerify(f6)) {
										cb.addToColection(Controller.addResource(f6));
										f6.clearFields();
										JFrame f = new JFrame();
										JOptionPane.showMessageDialog(f, "Resource Added");
										Controller.changeView(f6, f2);
										try {
											Controller.updateRepository(cb.getCol());
										} catch (Exception e2) {
											e2.printStackTrace();
										}
									} else {
										f6.getWrongLabel().setVisible(true);
									}
								}
							});

							f6.getBackButton().addActionListener(new ActionListener() { // BACK
								public void actionPerformed(ActionEvent e) {
									Controller.changeView(f6, f2);
								}
							});
						}
					});
				} else {
					f1.wrongUser();
				}
			}
		});
		f1.getregister().addActionListener(new ActionListener() { // REGISTER
			public void actionPerformed(ActionEvent e) {
				f1.dispose();
				RegisterFrame f8 = new RegisterFrame("Register");

				f8.getAdd().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						f8.resetWrong();
						if (Controller.verificador(f8)) {
							Persona p = Controller.addUserMethod(f8);
							usuarios.getUsuarios().put(p.getId(), p);
							f8.clearFields();
							JFrame f = new JFrame();
							JOptionPane.showMessageDialog(f, "User registered");
							Controller.changeView(f8, f1);
							try {
								Controller.updateUsers(usuarios.toArrayList());
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						} else {
							f8.getWrongLabel().setVisible(true);
						}

					}

				});

				f8.getBackButton().addActionListener(new ActionListener() { // BACK
					public void actionPerformed(ActionEvent e) {
						Controller.changeView(f8, f1);
					}
				});
			}
		});
		f1.getExitButton().addActionListener(new ActionListener() { // EXIT
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}