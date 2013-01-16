require 'bundler'
require 'rake'
require 'rake/testtask'
require 'cucumber'
require 'cucumber/rake/task'

task :default => :cucumber

namespace :cucumber do
  desc "Run the 'finished' scenarios (without @wip)"
  Cucumber::Rake::Task.new(:ready) do |t|
    t.cucumber_opts = "--tags ~@wip --tags ~@needs_preinstalled_sw --format pretty"
  end

  desc "Run the scenarios which don't require network access"
  Cucumber::Rake::Task.new(:nonetwork) do |t|
    t.cucumber_opts = "--tags ~@wip --tags ~@needs_preinstalled_sw --tags ~@realupdatecenter --format pretty"
  end

  desc "Run the scenarios tagged with @wip"
  Cucumber::Rake::Task.new(:wip) do |t|
    t.cucumber_opts = "--tags @wip,@needs_preinstalled_sw --format pretty"
  end
end

desc "Defaults to running cucumber:ready"
task :cucumber => "cucumber:ready"
