//
//  ContentView.swift
//  ios
//
//  Created by Ernesto De los Santos Cordero on 6/8/20.
//  Copyright © 2020 Blue Lake. All rights reserved.
//

import SwiftUI
import SharedCode

struct ContentView: View {
    @State var countries: String = ""
    @State var cities: String = ""
    @State var restaurants: String = ""
    private let viewModel = MainViewModel()

    var body: some View {
        initViewModel()
        viewModel.loadData()
        return VStack() {
            Text(countries).frame(maxWidth: .infinity, maxHeight: .infinity).frame(alignment: .center).font(.title).foregroundColor(.white).background(Color.green)
            Text(cities).frame(maxWidth: .infinity, maxHeight: .infinity).frame(alignment: .center).font(.title).foregroundColor(.white).background(Color.orange)
            Text(restaurants).frame(maxWidth: .infinity, maxHeight: .infinity).frame(alignment: .center).font(.title).foregroundColor(.white).background(Color.red)
        }.edgesIgnoringSafeArea(.all)
    }
}

extension ContentView {
    func initViewModel() {
        bindData()
    }

    private func bindData() {
        viewModel.countries.addObserver(observer: { it in
            if let text = it as? String {
                self.countries = text
            }
        })
        viewModel.cities.addObserver(observer: { it in
            if let text = it as? String {
                self.cities = text
            }
        })
        viewModel.restaurants.addObserver(observer: { it in
            if let text = it as? String {
                self.restaurants = text
            }
        })
    }

}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

