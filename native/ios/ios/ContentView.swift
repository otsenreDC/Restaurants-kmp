//
//  ContentView.swift
//  ios
//
//  Created by Ernesto De los Santos Cordero on 6/8/20.
//  Copyright © 2020 Blue Lake. All rights reserved.
//

import SwiftUI
import SharedCode

class MainViewModel: MainPresenter, ObservableObject {

    @Published var countries: String = ""
    @Published var cities: String = ""
    @Published var restaurants: String = ""

    let main: Main?

    init() {
        self.main = Main()
        self.main?.loadMain(presenter: self)
    }

    func loading(isLoading: Bool) {

    }

    func numberOfCities(value: String) {
        self.cities = value
    }

    func numberOfCountries(value: String) {
        self.countries = value
    }

    func numberOfRestaurants(value: String) {
        self.restaurants = value
    }
}

struct ContentView: View {

    @ObservedObject var viewModel: MainViewModel = MainViewModel()

    @State private var text = CommonKt.createApplicationScreenMessage()


    var body: some View {
        VStack {
            Text(viewModel.countries.uppercased()).frame(maxWidth: .infinity, maxHeight: .infinity).frame(alignment: .center).font(.title).foregroundColor(.white).background(Color.green)
            Text(viewModel.cities.uppercased()).frame(maxWidth: .infinity, maxHeight: .infinity).frame(alignment: .center).font(.title).foregroundColor(.white).background(Color.orange)
            Text(viewModel.restaurants.uppercased()).frame(maxWidth: .infinity, maxHeight: .infinity).frame(alignment: .center).font(.title).foregroundColor(.white).background(Color.red)
        }.edgesIgnoringSafeArea(.all)
    }

}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

